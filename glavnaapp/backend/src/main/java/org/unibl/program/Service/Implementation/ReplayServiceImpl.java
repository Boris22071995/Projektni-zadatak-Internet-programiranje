package org.unibl.program.Service.Implementation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Replay;
import org.unibl.program.Entity.Requests.ReplayRequest;
import org.unibl.program.Repository.ReplayRepository;
import org.unibl.program.Service.ReplayService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ReplayServiceImpl implements ReplayService {
    @Autowired
    private final ReplayRepository replayRepository;

    public ReplayServiceImpl(ReplayRepository replayRepository) {
        this.replayRepository = replayRepository;
    }

    @Override
    public List<Replay> getAll() {
        return replayRepository.findAll();
    }

    @Override
    public Replay createReplay(ReplayRequest replayRequest) {
        Replay replay = Replay.builder().idReplay(replayRequest.getIdReplay())
                                        .questionidQuestion(replayRequest.getQuestionidQuestion()).build();
        Replay saved = replayRepository.save(replay);
        return saved;
    }

    @Override
    public Optional<Replay> getReplay(Integer id) {
        log.info("Getting replay with id: " + id);
        return replayRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        replayRepository.deleteById(id);
    }
}
