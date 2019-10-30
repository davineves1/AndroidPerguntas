package br.com.jp.joojdeperguntas.pojo;

public class Perguntas {
    private Integer id;
    private String questao;
    private String altA;
    private String altB;
    private String altC;
    private String altD;
    private String altCorreta;

    public Integer getId() {
        return id;
    }

    public Perguntas(Integer id , String questao, String altA, String altB, String altC, String altD, String altCorreta) {
        this.id = id;
        this.questao = questao;
        this.altA = altA;
        this.altB = altB;
        this.altC = altC;
        this.altD = altD;
        this.altCorreta = altCorreta;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public void setAltA(String altA) {
        this.altA = altA;
    }

    public void setAltB(String altB) {
        this.altB = altB;
    }

    public void setAltC(String altC) {
        this.altC = altC;
    }

    public void setAltD(String altD) {
        this.altD = altD;
    }

    public void setAltCorreta(String altCorreta) {
        this.altCorreta = altCorreta;
    }

    public Perguntas() {
    }

    public String getQuestao() {
        return questao;
    }

    public String getAltA() {
        return altA;
    }

    public String getAltB() {
        return altB;
    }

    public String getAltC() {
        return altC;
    }

    public String getAltD() {
        return altD;
    }

    public String getAltCorreta() {
        return altCorreta;
    }
}
