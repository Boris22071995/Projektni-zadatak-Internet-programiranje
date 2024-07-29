package org.unibl.program.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Diary;
import org.unibl.program.Entity.Requests.DiaryRequest;
import org.unibl.program.Repository.DiaryRepository;
import org.unibl.program.Service.DiaryService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    private final DiaryRepository diaryRepository;

    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Override
    public List<Diary> getAll() {
        return diaryRepository.findAll();
    }

    @Override
    public Diary createDiary(DiaryRequest diaryRequest) {
        Diary diary = Diary.builder().idDiary(diaryRequest.getIdDiary())
                                     .useridUser(diaryRequest.getUseridUser()).build();
        Diary saved = diaryRepository.save(diary);
        return saved;
    }

    @Override
    public Optional<Diary> getDiary(Integer id) {
        log.info("Getting diary with id" + id);
        return diaryRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        diaryRepository.deleteById(id);
    }
}
