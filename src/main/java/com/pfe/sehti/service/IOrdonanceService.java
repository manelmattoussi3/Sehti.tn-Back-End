package com.pfe.sehti.service;

import java.util.List;

import com.pfe.sehti.entity.EtatOrdonance;
import com.pfe.sehti.entity.Ordonance;

public interface IOrdonanceService {
	public List<Ordonance>ConsulterOrdonancesActives();
	public void saveOrdonance(Ordonance o);
	public String NouveauteOrdonance(String idOrdonance);
	public List<Ordonance> AccederNouveauxOrdonances();
	public List<Ordonance> findAllOrdonances();
	public Ordonance findOrdonanceById(String idOrdonance);
}
