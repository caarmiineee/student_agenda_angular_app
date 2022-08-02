package com.nanosoft.student_agenda.dto.responseDto;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nanosoft.student_agenda.model.Tipologia;

import lombok.Data;

@Data
public class AppuntamentoResponseDto implements Comparable<AppuntamentoResponseDto>{

	private Integer id;
	private Integer ora;
	private String descrizione;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy")
	private LocalDate data;
	private String agendaNome;
	private String ufficioNome;
	private Tipologia tipologiaNome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOra() {
		return ora;
	}

	public void setOra(Integer ora) {
		this.ora = ora;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate localDate) {
		this.data = localDate;
	}

	public String getAgendaNome() {
		return agendaNome;
	}

	public void setAgendaNome(String agendaNome) {
		this.agendaNome = agendaNome;
	}

	public String getUfficioNome() {
		return ufficioNome;
	}
	
	public void setUfficioNome(String ufficioNome) {
		this.ufficioNome = ufficioNome;
	}

	public Tipologia getTipologiaNome() {
		return tipologiaNome;
	}

	public void setTipologiaNome(Tipologia tipologiaNome) {
		this.tipologiaNome = tipologiaNome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agendaNome, data, descrizione, id, ora, tipologiaNome, ufficioNome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppuntamentoResponseDto other = (AppuntamentoResponseDto) obj;
		return Objects.equals(agendaNome, other.agendaNome) && Objects.equals(data, other.data)
				&& Objects.equals(descrizione, other.descrizione) && Objects.equals(id, other.id)
				&& Objects.equals(ora, other.ora) && Objects.equals(tipologiaNome, other.tipologiaNome)
				&& Objects.equals(ufficioNome, other.ufficioNome);
	}

	@Override
	public int compareTo(AppuntamentoResponseDto o) {
		if(this.data.compareTo(o.getData()) > 0) return 1;
		if(this.data.compareTo(o.getData()) < 0) return -1;
		return 0;
	}


	
}
