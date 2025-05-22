public class Pregunta {

    private int idPregunta;
    private String pregunta;
    private String respuesta1;
    private String respuesta2;
    private String respuesta3;
    private int respuestaCorrecta;


    public Pregunta(int idPregunta, String pregunta, String respuesta1, String respuesta2, String respuesta3, int respuestaCorrecta) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}