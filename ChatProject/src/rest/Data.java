package rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
//name specifies the name of the table that will hold this entity
@Entity(name="Datas")
@NamedQueries({
	@NamedQuery(name = "allDatas", 
			query = "SELECT p from Datas p")
})
public class Data {
	@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
	@Column(nullable=false,length=500)
  private String name;
	@Column(nullable=false,length=500)
  private String data;

	public Long getId(){
		return this.id;
	}
	public Long setId(Long id){
		return this.id;
	}
	
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "name: " + name + ", data: " + data;
  }

} 

