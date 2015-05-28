package br.com.sysmed.controladores;
 
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;
 
@ManagedBean
@ViewScoped
public class ScheduleView implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScheduleModel cadastoTurnos;
    
    @PostConstruct
    public void init() {
        cadastoTurnos = new DefaultScheduleModel();
        cadastoTurnos.addEvent(new DefaultScheduleEvent("", getDate("AM",7,0,0),getDate("AM",11,00,0)));
        cadastoTurnos.addEvent(new DefaultScheduleEvent("", getDate("AM",7,0,1),getDate("AM",11,00,1)));
        cadastoTurnos.addEvent(new DefaultScheduleEvent("", getDate("AM",7,0,2),getDate("AM",11,00,2)));
        cadastoTurnos.addEvent(new DefaultScheduleEvent("", getDate("AM",7,0,3),getDate("AM",11,00,3)));
        cadastoTurnos.addEvent(new DefaultScheduleEvent("", getDate("AM",7,0,4),getDate("AM",11,00,4)));
         
    }
     
    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month
   
        return date.getTime();
    }
     
   
     
    public ScheduleModel getCadastoTurnos() {
        return cadastoTurnos;
    }
     
  
 
     
    private Date getDate(String turno,int horas,int minutos,int dias) {
        Calendar t = Calendar.getInstance();
        if( turno.equals("AM")){
        	 t.set(Calendar.AM_PM, Calendar.AM);
        }
        else{
        	t.set(Calendar.AM_PM, Calendar.PM);
        }
        t.set(Calendar.DATE, t.get(Calendar.DATE) + dias);
        t.set(Calendar.HOUR, horas);
        t.set(Calendar.MINUTE,  minutos);
         
        return t.getTime();
    }
     
    
     
   
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}