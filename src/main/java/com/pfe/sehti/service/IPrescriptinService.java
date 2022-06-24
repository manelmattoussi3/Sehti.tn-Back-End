package com.pfe.sehti.service;

import com.pfe.sehti.entity.Prescription;

public interface IPrescriptinService {
	public void prescrireMedicamentEtLePartagerAUneOrdonance(Prescription p, String idMedicament,String idOrdonance);
}
