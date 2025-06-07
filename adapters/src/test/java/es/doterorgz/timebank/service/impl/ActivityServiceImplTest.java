package es.doterorgz.timebank.service.impl;

import es.doterorgz.timebank.domain.Activity;
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

    @InjectMocks
    private ActivityServiceImpl service;

    @Test
    void createDelegatesToRepository() {
        Activity activity = new Activity();
        when(repository.save(activity)).thenReturn(activity);

        Activity result = service.create(activity);

        verify(repository).save(activity);
        assertSame(activity, result);
    }
}
