package com.grading.service;

import com.grading.persistence.entity.ChapterEntity;
import com.grading.persistence.entity.ColleagueEntity;
import com.grading.persistence.repository.ChapterRepository;
import com.grading.persistence.repository.ColleagueRepository;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ColleagueService extends ExcelImporterService<ColleagueEntity> {

    @Autowired
    private ColleagueRepository repository;

    @Autowired
    private ChapterRepository chapterRepository;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");

    @Override
    protected ColleagueEntity mapRowToEntity(Row row) {
        ColleagueEntity colleague = new ColleagueEntity();

        String firstname = row.getCell(0).getStringCellValue();
        String lastname = row.getCell(1).getStringCellValue();
        String email = row.getCell(2).getStringCellValue();
        String chapterName = row.getCell(3).getStringCellValue();
        String teamleadName = row.getCell(4).getStringCellValue();
        boolean isCeo = row.getCell(5).getBooleanCellValue();

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }

        ChapterEntity chapter = (ChapterEntity) chapterRepository.findByName(chapterName)
                .orElseThrow(() -> new IllegalArgumentException("Chapter not found: " + chapterName));

        String[] nameParts = teamleadName.split(" ");
        if (nameParts.length != 2) {
            throw new IllegalArgumentException("Invalid teamlead name format: " + teamleadName);
        }
        String teamleadFirstname = nameParts[0];
        String teamleadLastname = nameParts[1];
        ColleagueEntity teamlead = repository.findByFirstNameAndLastName(teamleadFirstname, teamleadLastname)
                .orElseThrow(() -> new IllegalArgumentException("Teamlead not found: " + teamleadName));

        colleague.setFirstname(firstname);
        colleague.setLastname(lastname);
        colleague.setEmail(email);
        colleague.setChapter(chapter);
        colleague.setTeamlead(teamlead);
        colleague.setIsceo(isCeo);

        return colleague;
    }

    @Override
    protected void saveEntity(ColleagueEntity entity) {
        repository.save(entity);
    }

    @Override
    public boolean supports(String type) {
        return "colleagues".equalsIgnoreCase(type);
    }
}
