package com.soap.app.populator;

import java.util.Collection;
import java.util.List;

public interface IPopulator<E, M> {
	M toModel(E input);

	E toExternalModel(M input);

	M populateModel(M output, E input);

	E populateExternalModel(E output, M input);

	List<E> toExternalModel(Collection<M> input);

	List<M> toModel(Collection<E> input);

}
