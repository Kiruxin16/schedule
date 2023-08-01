package threeoceans.fitness.ru.schedule.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import threeoceans.fitness.ru.schedule.entities.Hall;
import threeoceans.fitness.ru.schedule.repositories.HallRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallService {

    private final HallRepository hallRepository;
    public Hall findByName(String name) throws Exception{
        return hallRepository.findByName(name).orElseThrow(()->new Exception());
    }


    public Hall findById(Long id) throws Exception{
        return hallRepository.findById(id).orElseThrow(()->new Exception());
    }

    public List<Hall> findAll() {
        return hallRepository.findAll();
    }
}
