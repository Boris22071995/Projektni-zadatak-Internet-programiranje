package org.unibl.program.Service;


import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Replay;
import org.unibl.program.Entity.Requests.ReplayRequest;

import java.util.List;
import java.util.Optional;

@Service
public interface ReplayService {
   List<Replay> getAll();
   Replay createReplay(ReplayRequest replayRequest);
   Optional<Replay> getReplay(Integer id);
   void delete(Integer id);
}
