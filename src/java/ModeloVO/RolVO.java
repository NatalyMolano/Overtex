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
public class RolVO {
    private String ROLID,USUID;

    public RolVO() {
    }

    public RolVO(String ROLID, String USUID) {
        this.ROLID = ROLID;
        this.USUID = USUID;
    }

    public String getROLID() {
        return ROLID;
    }

    public void setROLID(String ROLID) {
        this.ROLID = ROLID;
    }

    public String getUSUID() {
        return USUID;
    }

    public void setUSUID(String USUID) {
        this.USUID = USUID;
    }
    
    
}
