package wladson.edy.enums;

public enum RacasEnum {
    HUMANO("Humano"),
    GREE("Gree"),
    RAKATA("Rakata");

    private String descricao;

    RacasEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
