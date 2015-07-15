package com.BS.controller;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.BS.domain.*;
import com.BS.hb.HibernateSessionFactory;


@Controller
public class MyController {
	static Manager manager=new Manager();
	String[] pers={"超级管理员","客户资源管理员","订单管理员","信息发布管理员","客服管理员","普通用户"};
	String[] ordStates={"等待处理","接受订单","订单完成","订单取消"};
	String[] ordKinds={"家政服务","家教服务","租房服务","家电维修","蔬菜配送"};
	
	
	@RequestMapping(value="/LoginTest", method = {RequestMethod.POST})
    public ModelAndView LoginTest(@RequestParam("username")String username,
    		@RequestParam("password")String password){
		ModelAndView modelAndView = new ModelAndView();
		
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Manager.class);  
        criteria.add(Restrictions.eq("username", username)); 
        criteria.add(Restrictions.eq("password", password));
        Manager m = (Manager) criteria.uniqueResult(); 
        session.close();
        if(m!=null){
        	manager=m;
        	modelAndView.setViewName("redirect:/index");
        }else{
        	manager.setUsername("error");
        	modelAndView.setViewName("redirect:/Login");
        }
          
        return modelAndView;
    }
	
	@RequestMapping(value="/Login", method = {RequestMethod.GET})
    public ModelAndView Login(){
        ModelAndView modelAndView = new ModelAndView(); 
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.setViewName("Login");  
        return modelAndView;
    }
	
	@RequestMapping(value="/index", method = {RequestMethod.GET})
    public ModelAndView Index(){
        ModelAndView modelAndView = new ModelAndView(); 
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.setViewName("index");  
        return modelAndView;
    }
	
	@RequestMapping(value="/UserInfo", method = {RequestMethod.GET})
    public ModelAndView UserInfo(){
        ModelAndView modelAndView = new ModelAndView(); 
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("contact", manager.getContact());
        modelAndView.addObject("per", pers[manager.getPer()]);
        modelAndView.setViewName("UserInfo");
        return modelAndView;
    }
	
	@RequestMapping(value="/Contact", method = {RequestMethod.GET})
    public ModelAndView Contact(){
        ModelAndView modelAndView = new ModelAndView(); 
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.setViewName("Contact");
        return modelAndView;
    }
	
	@RequestMapping(value="/PermissionManage-{page}", method = {RequestMethod.GET})
    public ModelAndView PermissionManage(@PathVariable(value="page") Integer page){
        ModelAndView modelAndView = new ModelAndView(); 
        int pageNo=page.intValue();
        int pageSize=7;
        
        Session session=HibernateSessionFactory.getSession();
        int total=((Long)session.createQuery("select count(*) from Manager" ).uniqueResult()).intValue();
        Criteria criteria = session.createCriteria(Manager.class);
        criteria.setFirstResult((pageNo - 1) * pageSize);  
        criteria.setMaxResults(pageSize);  
        criteria.setCacheable(true); // 设置缓存  
        List<Manager> list = criteria.list();
        session.close();
        
        modelAndView.addObject("list", list);
        modelAndView.addObject("pers", pers);
        modelAndView.addObject("cur", page);
        modelAndView.addObject("pageNum", (total+6)/7);
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("per", manager.getPer());
        modelAndView.setViewName("PermissionManage");
        return modelAndView;  
    }
	
	@RequestMapping(value="/PMS", method = {RequestMethod.POST})
    public ModelAndView PMS(@RequestParam("name")String name){
		ModelAndView modelAndView = new ModelAndView();
		
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Manager.class);   
        criteria.add(Restrictions.eq("username", name)); 
        Manager m = (Manager) criteria.uniqueResult();
        session.close();
        modelAndView.addObject("Manager", m);
        modelAndView.addObject("pers", pers);
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.setViewName("PMS");
        return modelAndView;
    }
	
	@RequestMapping(value="/PMGG-{username}", method = {RequestMethod.GET})
    public ModelAndView PMGG(@PathVariable(value="username")String username){
        ModelAndView modelAndView = new ModelAndView(); 
        
        Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Manager.class);  
        criteria.add(Restrictions.eq("username", username)); 
        Manager m = (Manager) criteria.uniqueResult(); 
        session.close();
        
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("pers", pers);
        modelAndView.addObject("manager", m);
        modelAndView.setViewName("PMGG");
        return modelAndView;  
    }
	
	@RequestMapping(value="/PMGGTest-{username}", method = {RequestMethod.POST})
    public ModelAndView PMGGTest(@RequestParam("perSelect")String perSelect,
    		@PathVariable(value="username")String username){
		ModelAndView modelAndView = new ModelAndView();
		
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Manager.class);   
        criteria.add(Restrictions.eq("username", username)); 
        Manager m = (Manager) criteria.uniqueResult();
        int per=Integer.parseInt(perSelect);
        if(per!=m.getPer()){
        	m.setPer(per);
        	Transaction tx = session.beginTransaction();  
            session.update(m);
            tx.commit();
        }
        session.close();
        modelAndView.setViewName("redirect:/PermissionManage-1");
        return modelAndView;
    }
	
	@RequestMapping(value="/UserManage-{page}", method = {RequestMethod.GET})
    public ModelAndView UserManage(@PathVariable(value="page") Integer page){
        ModelAndView modelAndView = new ModelAndView(); 
        int pageNo=page.intValue();
        int pageSize=7;
        
        Session session=HibernateSessionFactory.getSession();
        int total=((Long)session.createQuery("select count(*) from User" ).uniqueResult()).intValue();
        Criteria criteria = session.createCriteria(User.class);  
        criteria.setFirstResult((pageNo - 1) * pageSize);  
        criteria.setMaxResults(pageSize);  
        criteria.setCacheable(true); // 设置缓存  
        List<User> list = criteria.list();
        session.close();
        
        modelAndView.addObject("list", list);
        modelAndView.addObject("cur", page);
        modelAndView.addObject("pageNum", (total+6)/7);
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("per", manager.getPer());
        modelAndView.setViewName("UserManage");
        return modelAndView;  
    }
	
	@RequestMapping(value="/UMS", method = {RequestMethod.POST})
    public ModelAndView UMS(@RequestParam("name")String name){
		ModelAndView modelAndView = new ModelAndView();
		
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(User.class);   
        criteria.add(Restrictions.eq("username", name)); 
        User u = (User) criteria.uniqueResult(); 
        session.close();
        modelAndView.addObject("User", u);
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.setViewName("UMS");
        return modelAndView;
    }
	
	@RequestMapping(value="/UMGG-{username}", method = {RequestMethod.GET})
    public ModelAndView UMGG(@PathVariable(value="username")String username){
        ModelAndView modelAndView = new ModelAndView(); 
        
        Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(User.class);  
        criteria.add(Restrictions.eq("username", username)); 
        User u = (User) criteria.uniqueResult(); 
        session.close();
        
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("user", u);
        modelAndView.setViewName("UMGG");
        return modelAndView;  
    }
	
	@RequestMapping(value="/UMGGTest-{username}", method = {RequestMethod.POST})
    public ModelAndView UMGGTest(@PathVariable(value="username")String username){
		ModelAndView modelAndView = new ModelAndView();
		
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(User.class);   
        criteria.add(Restrictions.eq("username", username)); 
        User u = (User) criteria.uniqueResult();
        Transaction tx = session.beginTransaction();  
        u.setIsName(true);
        session.update(u);
        tx.commit();
        session.close();
        modelAndView.setViewName("redirect:/UMGG-"+username);
        return modelAndView;
    }
	
	@RequestMapping(value="/UserCZ-{username}", method = {RequestMethod.GET})
    public ModelAndView UserCZ(@PathVariable(value="username") String username){
        ModelAndView modelAndView = new ModelAndView(); 
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("user", username);
        modelAndView.setViewName("UserCZ");
        return modelAndView;  
    }
	
	@RequestMapping(value="/UserCZTest-{username}", method = {RequestMethod.POST})
    public ModelAndView UserCZTest(@PathVariable(value="username")String username,
    		@RequestParam("money")String money){
		ModelAndView modelAndView = new ModelAndView();
		
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(User.class);   
        criteria.add(Restrictions.eq("username", username)); 
        User u = (User) criteria.uniqueResult();
        Transaction tx = session.beginTransaction();  
        float f=u.getUserMon()+Float.parseFloat(money);
        u.setUserMon(f);
        session.update(u);
        tx.commit();
        session.close();
        
        modelAndView.setViewName("redirect:/UMGG-"+username);
        return modelAndView;
    }
	
	@RequestMapping(value="/OrderManage-{page}", method = {RequestMethod.GET})
    public ModelAndView OrderManage(@PathVariable(value="page") Integer page){
        ModelAndView modelAndView = new ModelAndView(); 
        int pageNo=page.intValue();
        int pageSize=7;
        
        Session session=HibernateSessionFactory.getSession();
        int total=((Long)session.createQuery("select count(*) from Order" ).uniqueResult()).intValue();
        Criteria criteria = session.createCriteria(Order.class);  
        criteria.setFirstResult((pageNo - 1) * pageSize);  
        criteria.setMaxResults(pageSize);  
        criteria.setCacheable(true); // 设置缓存  
        List<Order> list = criteria.list();
        session.close();

        modelAndView.addObject("cur", page);
        modelAndView.addObject("pageNum", (total+6)/7);
        modelAndView.addObject("list", list);
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("per", manager.getPer());
        modelAndView.addObject("ordStates", ordStates);
        modelAndView.addObject("ordKinds", ordKinds);
        modelAndView.setViewName("OrderManage");
        return modelAndView;  
    }
	
	@RequestMapping(value="/OMS", method = {RequestMethod.POST})
    public ModelAndView OMS(@RequestParam("ordId")String ordId){
		ModelAndView modelAndView = new ModelAndView();
		
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Order.class);   
        criteria.add(Restrictions.eq("ordId", Integer.valueOf(ordId))); 
        Order ord = (Order) criteria.uniqueResult(); 
        session.close();
        modelAndView.addObject("Order", ord);
        modelAndView.addObject("ordStates", ordStates);
        modelAndView.addObject("ordKinds", ordKinds);
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.setViewName("OMS");
        return modelAndView;
    }
	
	@RequestMapping(value="/OMGG-{ordId}", method = {RequestMethod.GET})
    public ModelAndView OMGG(@PathVariable(value="ordId")int ordId){
        ModelAndView modelAndView = new ModelAndView(); 
        
        Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Order.class);  
        criteria.add(Restrictions.eq("ordId", ordId)); 
        Order ord = (Order) criteria.uniqueResult(); 
        session.close();
        
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("Order", ord);
        modelAndView.addObject("ordStates", ordStates);
        modelAndView.addObject("ordKinds", ordKinds);
        modelAndView.setViewName("OMGG");
        return modelAndView;  
    }
	
	@RequestMapping(value="/OMGGTest-{ordId}", method = {RequestMethod.POST})
    public ModelAndView OMGGTest(@PathVariable(value="ordId")int ordId){
		ModelAndView modelAndView = new ModelAndView();
		
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Order.class);   
        criteria.add(Restrictions.eq("ordId", ordId)); 
        Order ord = (Order) criteria.uniqueResult();
        Transaction tx = session.beginTransaction();  
        ord.setOrdState(1);
        session.update(ord);
        if(ord.getOrdKind()==2){
        	Criteria criteria2 = session.createCriteria(Life_ZF.class);   
            criteria2.add(Restrictions.eq("houId", ord.getSerId())); 
            Life_ZF zf = (Life_ZF) criteria2.uniqueResult();
            zf.setIsRent(true);
            session.update(zf);
        }
        tx.commit();
        session.close();
        modelAndView.setViewName("redirect:/OMGG-"+ordId);
        return modelAndView;
    }
	
	@RequestMapping(value="/InfoFB_News", method = {RequestMethod.GET})
    public ModelAndView InfoFB_News(){
        ModelAndView modelAndView = new ModelAndView(); 
        
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("per", manager.getPer());
        modelAndView.setViewName("InfoFB_News");
        return modelAndView;  
    }
	
	@RequestMapping(value="/InfoFB_News_Upload", method = {RequestMethod.POST})
    public ModelAndView InfoFB_News_Upload(@RequestParam("photo") MultipartFile photo,
    		@RequestParam("txt") MultipartFile txt,@RequestParam("newsKind") String newsKind,
    		@RequestParam("title") String title){
        ModelAndView modelAndView = new ModelAndView(); 
        
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(date);
        String dir="D:/Tomcat 6.0/webapps/test1/files/news/"+newsKind;
        String photo_filename = photo.getOriginalFilename();
        String txt_filename=txt.getOriginalFilename();
        
        String table;
        News news;
        if(newsKind.equals("fin")){
        	news=new FinNews();
        	table="FinNews";
        }else if(newsKind.equals("hea")){
        	news=new HeaNews();
        	table="HeaNews";
        }else{
        	news=new LifeNews();
        	table="LifeNews";
        }
        
        Session session=HibernateSessionFactory.getSession();  
        Transaction tx = session.beginTransaction();
        Integer id=(Integer)session.createQuery("select max(n.newsId) from "+table+" n" ).uniqueResult();
        int newsId = id.intValue()+1;
        news.setNewsTitle(title);
        news.setNewsTime(time);
        news.setRep(manager.getUsername());
        news.setLink("http://nba.hupu.com/");
        news.setPhoAmo(1);
        news.setNewsPath("news/fin/"+newsId+"/"+txt_filename);
        news.setPhoPath("news/fin/"+newsId+"/photo/");
    	session.save(news);
        tx.commit();  
        session.close();
        
        try {
			FileUtils.writeByteArrayToFile(new File(dir+"/"+newsId+"/photo",photo_filename), photo.getBytes());
			FileUtils.writeByteArrayToFile(new File(dir+"/"+newsId,txt_filename), txt.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        modelAndView.setViewName("redirect:/InfoFB_News?s=y");
        return modelAndView;  
    }
	
	@RequestMapping(value="/InfoFB_Finance-{kind}", method = {RequestMethod.GET})
    public ModelAndView InfoFB_Finance(@PathVariable(value="kind") String kind){
        ModelAndView modelAndView = new ModelAndView(); 
        
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("per", manager.getPer());
        modelAndView.addObject("kind", kind);
        modelAndView.setViewName("InfoFB_Finance");
        return modelAndView;  
    }
	
	@RequestMapping(value="/InfoFB_FinanceTest-{kind}", method = {RequestMethod.POST})
    public ModelAndView InfoFB_FinanceTest(HttpServletRequest request,
    		@PathVariable(value="kind") String kind){
        ModelAndView modelAndView = new ModelAndView();
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(date);
        
        Session session=HibernateSessionFactory.getSession();  
        Transaction tx = session.beginTransaction();
        if(kind.equals("JJ")||kind.equals("HJ")){
        	String proName=request.getParameter("proName");
        	String proExp=request.getParameter("proExp");
        	String proIns=request.getParameter("proIns");
        	String proEva=request.getParameter("proEva");
        	String proCode=request.getParameter("proCode");
        	float proRate=Float.parseFloat(request.getParameter("proRate"));
        	String beginDate=time;
        	int buyTimes=0;
        	int price=Integer.valueOf(request.getParameter("price"));
        	if(kind.equals("JJ")){
        		Finance_JJ fj=new Finance_JJ(proName,proExp,proIns,proEva,proCode
        				,proRate,beginDate,buyTimes,price);
        		session.save(fj);
        	}else{
        		Finance_HJ hj=new Finance_HJ(proName,proExp,proIns,proEva,proCode
        				,proRate,beginDate,buyTimes,price);
        		session.save(hj);
        	}
        }else if(kind.equals("ZQ")||kind.equals("BX")){
        	String comName=request.getParameter("comName");
        	int buyTimes=0;
        	int price=Integer.valueOf(request.getParameter("price"));
        	if(kind.equals("ZQ")){
        		String zqExp=request.getParameter("zqExp");
        		float zqRate=Float.parseFloat(request.getParameter("zqRate"));
        		Finance_ZQ fz=new Finance_ZQ(zqExp,comName,zqRate,buyTimes,price);
        		session.save(fz);
        	}else{
        		String bxExp=request.getParameter("bxExp");
        		float bxRate=Float.parseFloat(request.getParameter("bxRate"));
        		Finance_BX fb=new Finance_BX(bxExp,comName,bxRate,buyTimes,price);
        		session.save(fb);
        	}
        }
        tx.commit();  
        session.close();
        modelAndView.setViewName("redirect:/InfoFB_Finance-"+kind+"?s=y&k="+kind);
        return modelAndView;
	}
	
	@RequestMapping(value="/InfoFB_Health", method = {RequestMethod.GET})
    public ModelAndView InfoFB_Health(){
        ModelAndView modelAndView = new ModelAndView(); 
        
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("per", manager.getPer());
        modelAndView.setViewName("InfoFB_Health");
        return modelAndView;  
    }
	
	@RequestMapping(value="/InfoFB_Health_Upload", method = {RequestMethod.POST})
    public ModelAndView InfoFB_Health_Upload(@RequestParam("photo") MultipartFile photo,
    		@RequestParam("txt") MultipartFile txt,@RequestParam("kind") String kind,
    		@RequestParam("title") String title){
        ModelAndView modelAndView = new ModelAndView(); 
        
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(date);
        String dir="D:/Tomcat 6.0/webapps/test1/files/"+kind;
        String photo_filename = photo.getOriginalFilename();
        String txt_filename=txt.getOriginalFilename();
        
        Session session=HibernateSessionFactory.getSession();  
        Transaction tx = session.beginTransaction();
        Health hea = null;
        int heaId=0;
        if(kind.equals("heaKno")){
        	hea=new HealthKno();
        	Integer id=(Integer)session.createQuery("select max(h.knoId) from HealthKno h" ).uniqueResult();
        	heaId = id.intValue()+1;
        	hea.setTxtPath("heaKno/"+heaId+"/"+txt_filename);
        	hea.setPhoPath("heaKno/"+heaId+"/photo");
        }else if(kind.equals("heaAct")){
        	hea=new HealthAct();
        	Integer id=(Integer)session.createQuery("select max(h.actId) from HealthAct h" ).uniqueResult();
        	heaId = id.intValue()+1;
        	hea.setTxtPath("heaAct/"+heaId+"/"+txt_filename);
        	hea.setPhoPath("heaAct/"+heaId+"/photo");
        	((HealthAct) hea).setBeginDate(time);
        }  
        hea.setActName(title);
        hea.setPhoAmount(1);
    	session.save(hea);
        tx.commit();  
        session.close();
        
        try {
			FileUtils.writeByteArrayToFile(new File(dir+"/"+heaId+"/photo",photo_filename), photo.getBytes());
			FileUtils.writeByteArrayToFile(new File(dir+"/"+heaId,txt_filename), txt.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        modelAndView.setViewName("redirect:/InfoFB_Health?s=y");
        return modelAndView;  
    }
	
	@RequestMapping(value="/InfoFB_Life-{kind}", method = {RequestMethod.GET})
    public ModelAndView InfoFB_Life(@PathVariable(value="kind") String kind){
        ModelAndView modelAndView = new ModelAndView(); 
        
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("per", manager.getPer());
        modelAndView.addObject("kind", kind);
        modelAndView.setViewName("InfoFB_Life");
        return modelAndView;  
    }
	
	@RequestMapping(value="/InfoFB_LifeTest-{kind}", method = {RequestMethod.POST})
    public ModelAndView InfoFB_LifeTest(HttpServletRequest request,
    		@PathVariable(value="kind") String kind){
        ModelAndView modelAndView = new ModelAndView();
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(date);
        
        Session session=HibernateSessionFactory.getSession();  
        Transaction tx = session.beginTransaction();
        
        if(kind.equals("JZ")){
        	String serName=request.getParameter("serName");
        	String serKind=request.getParameter("serKind");
        	String serExp=request.getParameter("serExp");
        	float serPrice=Float.parseFloat(request.getParameter("serPrice"));
        	String contact=request.getParameter("contact");
        	Life_JZ jz=new Life_JZ(serName,serKind,serExp,serPrice,contact);
        	session.save(jz);
        }else if(kind.equals("JJ")){
        	String teaName=request.getParameter("teaName");
        	String teaExp=request.getParameter("teaExp");
        	int feeStd=Integer.valueOf(request.getParameter("feeStd"));
        	String times=request.getParameter("time");
        	String contact=request.getParameter("contact");
        	Life_JJ jj=new Life_JJ(teaName,teaExp,feeStd,times,contact);
        	session.save(jj);
        }else if(kind.equals("ZF")){
        	String houAdd=request.getParameter("houAdd");
        	int houSize=Integer.valueOf(request.getParameter("houSize"));
        	String furExp=request.getParameter("furExp");
        	int fee=Integer.valueOf(request.getParameter("fee"));
        	String hostName=request.getParameter("hostName");
        	String contact=request.getParameter("contact");
        	String beginDate=time;
        	boolean isRent=false;
        	Life_ZF zf=new Life_ZF(houAdd,houSize,furExp,fee,hostName,contact,beginDate,isRent);
        	session.save(zf);
        }else if(kind.equals("JD")){
        	String eleName=request.getParameter("eleName");
        	String eleKind=request.getParameter("eleKind");
        	String eleExp=request.getParameter("eleExp");
        	float elePrice=Float.parseFloat(request.getParameter("elePrice"));
        	String contact=request.getParameter("contact");
        	Life_JD jd=new Life_JD(eleName,eleKind,eleExp,elePrice,contact);
        	session.save(jd);
        }else if(kind.equals("SC")){
        	String vegName=request.getParameter("vegName");
        	String vegKind=request.getParameter("vegKind");
        	String vegExp=request.getParameter("vegExp");
        	String vegAdd=request.getParameter("vegAdd");
        	float vegPrice=Float.parseFloat(request.getParameter("vegPrice"));
        	String dispactTime1=request.getParameter("dispactTime1");
        	String dispactTime2=request.getParameter("dispactTime2");
        	String contact=request.getParameter("contact");
        	Life_SC sc=new Life_SC(vegName,vegKind,vegExp,vegAdd,vegPrice,dispactTime1,dispactTime2,contact);
        	session.save(sc);
        }
        tx.commit();  
        session.close();
        modelAndView.setViewName("redirect:/InfoFB_Life-"+kind+"?s=y&k="+kind);
        return modelAndView;
	}
	
	@RequestMapping(value="/CSManage-{page}", method = {RequestMethod.GET})
    public ModelAndView CSManage(@PathVariable(value="page") Integer page){
		ModelAndView modelAndView = new ModelAndView(); 
        int pageNo=page.intValue();
        int pageSize=7;
        
        Session session=HibernateSessionFactory.getSession();
        int total=((Long)session.createQuery("select count(*) from Message" ).uniqueResult()).intValue();
        Criteria criteria = session.createCriteria(Message.class);  
        criteria.setFirstResult((pageNo - 1) * pageSize);  
        criteria.setMaxResults(pageSize);  
        criteria.setCacheable(true); // 设置缓存  
        List<Message> list = criteria.list();
        session.close(); 
        
        modelAndView.addObject("cur", page);
        modelAndView.addObject("pageNum", (total+6)/7);
        modelAndView.addObject("list", list);
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("per", manager.getPer());
        modelAndView.setViewName("CSManage");
        return modelAndView;  
    }
	
	@RequestMapping(value="/CMGG-{id}", method = {RequestMethod.GET})
    public ModelAndView CMGG(@PathVariable(value="id")int id){
        ModelAndView modelAndView = new ModelAndView(); 
        
        Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Message.class);  
        criteria.add(Restrictions.eq("id", id)); 
        Message msg = (Message) criteria.uniqueResult(); 
        session.close();
        
        modelAndView.addObject("username", manager.getUsername());
        modelAndView.addObject("Message", msg);
        modelAndView.setViewName("CMGG");
        return modelAndView;  
    }
	
	@RequestMapping(value="/CMGGTest-{id}", method = {RequestMethod.POST})
    public ModelAndView CMGGTest(@PathVariable(value="id")int id,
    		@RequestParam("reply")String reply){
		ModelAndView modelAndView = new ModelAndView();
		
		Session session=HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(Message.class);   
        criteria.add(Restrictions.eq("id", id)); 
        Message msg = (Message) criteria.uniqueResult();
        Transaction tx = session.beginTransaction();  
        msg.setReply(reply);
        session.update(msg);
        tx.commit();
        session.close();
        modelAndView.setViewName("redirect:/CSManage-1");
        return modelAndView;
    }
	
}
