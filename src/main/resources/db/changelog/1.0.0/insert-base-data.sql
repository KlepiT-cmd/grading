DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 From grading.LEVEL) THEN
        insert into grading.LEVEL values (gen_random_uuid(), 'Junior1');
        insert into grading.LEVEL values (gen_random_uuid(), 'Junior2');
        insert into grading.LEVEL values (gen_random_uuid(), 'Medior1');
        insert into grading.LEVEL values (gen_random_uuid(), 'Medior2');
        insert into grading.LEVEL values (gen_random_uuid(), 'Senior1');
        insert into grading.LEVEL values (gen_random_uuid(), 'Senior2');
        insert into grading.LEVEL values (gen_random_uuid(), 'Expert');
    END IF;
END $$;

DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 From grading.LEVEL) THEN
        insert into grading.CHAPTER values (gen_random_uuid(), 'ANALYST');
        insert into grading.CHAPTER values (gen_random_uuid(), 'BACKEND_DEVELOPER');
        insert into grading.CHAPTER values (gen_random_uuid(), 'FRONTEND_DEVELOPER');
        insert into grading.CHAPTER values (gen_random_uuid(), 'QA');
    END IF;
END $$;