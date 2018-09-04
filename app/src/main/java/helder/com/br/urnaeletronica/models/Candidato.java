package helder.com.br.urnaeletronica.models;

import java.io.Serializable;

public class Candidato implements Serializable {

    private Long id;
    private String nome;
    private String detalhes;
    private String partido;
    private String foto;
    private String propostas;
    private String site;
    private Integer totalVotos;
    private Integer votosPercentuais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPropostas() {
        return propostas;
    }

    public void setPropostas(String propostas) {
        this.propostas = propostas;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Integer getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(Integer totalVotos) {
        this.totalVotos = totalVotos;
    }

    public Integer getVotosPercentuais() {
        return votosPercentuais;
    }

    public void setVotosPercentuais(Integer votosPercentuais) {
        this.votosPercentuais = votosPercentuais;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", detalhes='" + detalhes + '\'' +
                ", partido='" + partido + '\'' +
                ", foto='" + foto + '\'' +
                ", propostas='" + propostas + '\'' +
                ", site='" + site + '\'' +
                ", totalVotos=" + totalVotos +
                ", votosPercentuais=" + votosPercentuais +
                '}';
    }
}
