package com.darkcode.app.model;

public class User {
    private String idU;
    private String nombreU;
    private String apellidoU;
    private String emailU;
    private String contraseñaU;
    private String rolU;
    private String fecha_registroU;
    
    public String getIdU() {
        return idU;
    }
    public void setIdU(String idU) {
        this.idU = idU;
    }
    public String getNombreU() {
        return nombreU;
    }
    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }
    public String getApellidoU() {
        return apellidoU;
    }
    public void setApellidoU(String apellidoU) {
        this.apellidoU = apellidoU;
    }
    public String getEmailU() {
        return emailU;
    }
    public void setEmailU(String emailU) {
        this.emailU = emailU;
    }
    public String getContraseñaU() {
        return contraseñaU;
    }
    public void setContraseñaU(String contraseñaU) {
        this.contraseñaU = contraseñaU;
    }
    public String getRolU() {
        return rolU;
    }
    public void setRolU(String rolU) {
        this.rolU = rolU;
    }
    public String getFecha_registroU() {
        return fecha_registroU;
    }
    public void setFecha_registroU(String fecha_registroU) {
        this.fecha_registroU = fecha_registroU;
    }
    @Override
    public String toString() {
        return "User [idU=" + idU + ", nombreU=" + nombreU + ", apellidoU=" + apellidoU + ", emailU=" + emailU
                + ", contraseñaU=" + contraseñaU + ", rolU=" + rolU + ", fecha_registroU=" + fecha_registroU + "]";
    }

    
}
