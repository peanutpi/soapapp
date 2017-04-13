package com.soap.app.populator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractPopulator<E, M> implements IPopulator<E, M>{

	public M toModel(E input) {
		if (input == null) {
			return null;
		}
		return populateModel(getModelInstance(), input);
	}
	public E toExternalModel(M input) {
		if (input == null) {
			return null;
		}
		return populateExternalModel(getExternalModelInstance(), input);
	}
	public M populateModel(M output, E input) {
		this.doPopulateToModel(output, input);
		return output;
	}
	public E populateExternalModel(E output, M input) {
		this.doPopulateToExternalModel(input, output);
		return output;
	}
	
	public List<E> toExternalModel(Collection<M> input) {
		List<E> response= new ArrayList<E>();
		for(M in : input){
			response.add(toExternalModel(in));
		}
		return response;
	}

	public List<M> toModel(Collection<E> input) {
		List<M> response= new ArrayList<M>();
		for(E in : input){
			response.add(toModel(in));
		}
		return response;
	}
	
	public abstract M getModelInstance();
	public abstract E getExternalModelInstance();
	public abstract void doPopulateToModel(M output, E input);
	public abstract void doPopulateToExternalModel(M input, E output);
	
	
}
