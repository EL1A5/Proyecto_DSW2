package com.epy.main.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


import com.epy.main.dto.TipoSolicitudDTO;
import com.epy.main.entity.TipoSolicitud;



@Component("convertidor")
public class ConvertidorTipoSolicitud{
	
	public List<TipoSolicitudDTO> convertirLista(List<TipoSolicitud> listaJPA){
		List<TipoSolicitudDTO> lstPokemonModel = new ArrayList<>();
		
		for(TipoSolicitud pokemon: listaJPA){
			lstPokemonModel.add(new TipoSolicitudDTO(pokemon));
		}
		
		return lstPokemonModel;
	}
	
	public TipoSolicitudDTO convertirDTO(TipoSolicitud nota){
		return new TipoSolicitudDTO(nota);
	}

}
