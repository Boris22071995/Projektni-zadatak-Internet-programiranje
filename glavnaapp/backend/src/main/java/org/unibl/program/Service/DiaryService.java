package org.unibl.program.Service;

import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Diary;
import org.unibl.program.Entity.Requests.DiaryRequest;

import java.util.List;
import java.util.Optional;

@Service
public interface DiaryService {
    List<Diary> getAll();
    Diary createDiary(DiaryRequest diaryRequest);
    Optional<Diary> getDiary(Integer id);
    void delete(Integer id);
}
