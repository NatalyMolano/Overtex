/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author APRENDIZ
 */
public class UsuarioVO_1 
{
   private String usuId,usulogin,usupassword,idRool;

    public String getIdRool() {
        return idRool;
    }

    public void setIdRool(String idRool) {
        this.idRool = idRool;
    }
   

   

    public UsuarioVO_1(String usuId, String usulogin, String usupassword) {
        this.usuId = usuId;
        this.usulogin = usulogin;
        this.usupassword = usupassword;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getUsulogin() {
        return usulogin;
    }

    public void setUsulogin(String usulogin) {
        this.usulogin = usulogin;
    }

    public String getUsupassword() {
        return usupassword;
    }

    public void setUsupassword(String usupassword) {
        this.usupassword = usupassword;
    }

    
}
