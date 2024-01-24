import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {
  @Test
  public void Tests() {
    assertEquals("makeReadable(0)", "00:00:00", HumanReadableTime.makeReadable(0));
    assertEquals("makeReadable(5)", "00:00:05", HumanReadableTime.makeReadable(5));
    assertEquals("makeReadable(60)", "00:01:00", HumanReadableTime.makeReadable(60));
    assertEquals("makeReadable(86399)", "23:59:59", HumanReadableTime.makeReadable(86399));
    assertEquals("makeReadable(359999)", "99:59:59", HumanReadableTime.makeReadable(359999));
  }
}

public class HumanReadableTime {
  public static String makeReadable(int seconds) {
    
    // Declaramos minutos y horas int y String para devolver el resultado
    int minutos = 0;
    int horas = 0;
    String secondsS = "";
    String minutosS = "";
    String horasS = "";
    
    // Si los segundos son menores a 60 Sumamos los segundos a la string
    if(seconds < 60){
      secondsS = ""+seconds;
    }
    // Si segundos es igual a 0 devolvemos 00:00:00
    if(seconds == 0){
      return "00:00:00";
    }
    // Si segundos es mayor a 359999 devolvemos un mensaje de error 
    if(seconds > 359999){
      return "The number is so big";
    }
    // Si segundos es mayor o igual a 60 hacemos el calculo
    else if(seconds >= 60){
        minutos = seconds / 60;
    // Calculamos para dejar los segundos que sobran
        seconds = seconds - minutos * 60;  
    // Guardamos los segundos en la variable String
        secondsS = ""+seconds;
    // Si minutos es menor a 60 guardamos los minutos en la variable String
      if(minutos < 60){
      minutosS = ""+minutos;
    }
    // Si minutos es mayor o igual a 60 hacemos el calculo para pasar a horas
    }if (minutos >= 60){
        horas = minutos /60;
    // Calculamos para dejar los minutos que sobran
        minutos = minutos - horas * 60;
    // Guardamos las horas y los minutos en la variable String
      horasS= ""+horas;
      minutosS = ""+minutos;
    }
    
    // Si uno de los tres es menor a 10 le añadimos un 0 en la variable String
      if(seconds < 10){
        secondsS = "0"+seconds;
      }if(minutos < 10){
        minutosS = "0"+minutos;
      }if(horas < 10){
        horasS = "0"+horas;
      }
    
    // Devolvemos el resultado con :
    return horasS+":"+minutosS+":"+secondsS;
  }
}
