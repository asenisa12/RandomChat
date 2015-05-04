package rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/history")
public class History {
	private static EntityManagerFactory factory;

	
	public History() {
		factory = Services.getEntityManagerFactory();
	}
  @Path("/get")
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getHistory() {
	String historyList = "";
	EntityManager em = factory.createEntityManager();

 
    List<Data> DataList = em.createNamedQuery("allDatas", Data.class).getResultList();;
    for (Data data1 : DataList) {
    	historyList+="	<li>"+data1.toString()+"</li>\n";
    }
    em.close();
    return historyList;
  }
  
  @Path("/post")
  @POST
  @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  public Data postData(Data d)
  {
	    EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(d);
	    em.getTransaction().commit();
	    
	  em.close();
	  return d;
  }
  
  
  
  
} 