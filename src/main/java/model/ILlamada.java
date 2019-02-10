package model;

import java.time.Instant;

public interface ILlamada {

	public void setDuracionLlamada(int segundos);
	public int getDuracionLlamada();
	public void setTimeLlamada(Instant timeLlamada);
	public Instant getTimeLlamada();
	public String getUniqueId();
}
