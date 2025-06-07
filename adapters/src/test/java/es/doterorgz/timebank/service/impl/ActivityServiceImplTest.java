package es.doterorgz.timebank.service.impl;

import es.doterorgz.timebank.domain.Activity;
import es.doterorgz.timebank.adapters.entities.ActivityEntity;
import es.doterorgz.timebank.mapper.ActivityEntityMapper;
import es.doterorgz.timebank.repository.ActivityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertSame;

@ExtendWith(MockitoExtension.class)
class ActivityServiceImplTest {

    @Mock
    private ActivityRepository repository;

    @Mock
    private ActivityEntityMapper mapper;

    @InjectMocks
    private ActivityServiceImpl service;

    @Test
    void createDelegatesToRepository() {
        Activity activity = new Activity();
        ActivityEntity entity = new ActivityEntity();

        when(mapper.toEntity(activity)).thenReturn(entity);
        when(repository.save(entity)).thenReturn(entity);
        when(mapper.toDomain(entity)).thenReturn(activity);

        Activity result = service.create(activity);

        verify(mapper).toEntity(activity);
        verify(repository).save(entity);
        verify(mapper).toDomain(entity);
        assertSame(activity, result);
    }
}
