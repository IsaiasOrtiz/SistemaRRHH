/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.utilidades;

import com.bitlab.propiedades.Propiedades;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Douglas Isaias Valle Ortiz
 */
public class Mensajes {
      private static Logger log= LoggerFactory.getLogger(Mensajes.class);
    /**
     * Metodo para enviar un mensaje.
     * @param asunto Asunto del mensaje
     * @param cuerpo Cuerpo del mensaje
     * @param destinatario Correo al cual se enviara la informacion.
     */
    public void enviarMensaje(String asunto, String cuerpo, String destinatario) {
       
        try {
            //instanciando clases y carga de archivos de propiedades.
            String propiedades = "config.properties";
            Encryptacion encriptacion = new Encryptacion();
            Properties pro = new Properties();
            pro.load(Propiedades.flujoDeDatos(propiedades));

            //Desencriptado.
            String valor1 = encriptacion.getDesencryptacion((String) pro.get("cod"));
            String valor2 = encriptacion.getDesencryptacion((String) pro.get("c1Des"));
            short valor3 = Short.parseShort(encriptacion.getDesencryptacion((String) pro.get("por")));
            String valor4 = encriptacion.getDesencryptacion((String) pro.get("sm"));
            //Enviando mensaje
            Email email = new SimpleEmail();
            email.setHostName(valor4);
            email.setSmtpPort(valor3);
            email.setAuthentication(valor1, valor2);
            email.setSSLOnConnect(true);
            email.setFrom(destinatario);
            email.setSubject(asunto);
            email.setMsg(String.valueOf(cuerpo));
            email.addTo(destinatario);
            email.send();
            log.debug("Se envio un mensaje.");
        } catch (IOException ex) {
            log.error("Ocurrio un error!");
            for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
              log.error(stackTraceElement.toString());
            }
            
            
        } catch (EmailException ex) {
          log.error("Ocurrio un error al enviar el correo electronico.");
            for (StackTraceElement stackTraceElement : ex.getStackTrace()) {
                log.error(stackTraceElement.toString());
            }
        }

    }
}
