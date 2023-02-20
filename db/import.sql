INSERT INTO public.role (id, name) VALUES (DEFAULT, 'student'); --role_id 1
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'teacher'); --role_id 2
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin'); --role_id 2
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'pending'); --role_id 2

INSERT INTO public.user (id, role_id, username, password, status) VALUES (DEFAULT, 1, 'student', '123', 'A'); --user_id 1
INSERT INTO public.user (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'teacher', '123', 'A'); --user_id 2
INSERT INTO public.user (id, role_id, username, password, status) VALUES (DEFAULT, 3, 'admin', '123', 'A'); --user_id 2
INSERT INTO public.user (id, role_id, username, password, status) VALUES (DEFAULT, 4, 'pending', '123', 'A'); --user_id 2

INSERT INTO public.quiz (id, user_id, name, status, is_public, required_count, type, timestamp) VALUES (DEFAULT, 1, 'private (student)  Quiz', 'A', false, 2, 'Q', '2023-02-07 14:38:01.000000'); --quiz_id 1
INSERT INTO public.quiz (id, user_id, name, status, is_public, required_count, type, timestamp) VALUES (DEFAULT, 1, 'private (student)  Flash', 'A', false, 2, 'F', '2023-02-07 14:38:02.000000'); --quiz_id 2
INSERT INTO public.quiz (id, user_id, name, status, is_public, required_count, type, timestamp) VALUES (DEFAULT, 2, 'public Quiz', 'A', true, 1, 'Q', '2023-02-07 14:38:03.000000'); --quiz_id 3
INSERT INTO public.quiz (id, user_id, name, status, is_public, required_count, type, timestamp) VALUES (DEFAULT, 2, 'public Flash', 'A', true, 1, 'F', '2023-02-07 14:38:04.000000'); --quiz_id 4


INSERT INTO public.question (id, text, picture, type) VALUES (DEFAULT, 'private (student) Quizz 1 kysimus', NULL, 'Q');  --question_id 1
INSERT INTO public.question (id, text, picture, type) VALUES (DEFAULT, 'private (student) Quizz 2 kysimus', NULL, 'Q');  --question_id 2
INSERT INTO public.question (id, text, picture, type) VALUES (DEFAULT, 'private (student) Flash 1 kysimus', NULL, 'F');  --question_id 3
INSERT INTO public.question (id, text, picture, type) VALUES (DEFAULT, 'private (student) Flash 2 kysimus', NULL, 'F');  --question_id 4
INSERT INTO public.question (id, text, picture, type) VALUES (DEFAULT, 'public Quiz 1 kysimus', null, 'Q');  --question_id 5
INSERT INTO public.question (id, text, picture, type) VALUES (DEFAULT, 'public Quiz 2 kysimus', null, 'Q');  --question_id 6
INSERT INTO public.question (id, text, picture, type) VALUES (DEFAULT, 'public Flash 1 kysimus', null, 'F');  --question_id 7
INSERT INTO public.question (id, text, picture, type) VALUES (DEFAULT, 'public flash 2 kysimus', null, 'F');  --question_id 8


INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'private (student)  Quizz 1 kysimus vastus A (vale)', null, 1, false); --answer_id 1
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'private (student)  Quizz 1 kysimus vastus B (vale)', null, 1, false); --answer_id 2
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'private (student)  Quizz 1 kysimus vastus C (oige)', null, 1, true); --answer_id 3
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'private (student)  Quizz 2 kysimus vastus A (vale)', null, 2, false); --answer_id 4
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'private (student)  Quizz 2 kysimus vastus B (vale)', null, 2, false); --answer_id 5
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'private (student)  Quizz 2 kysimus vastus C (oige)', null, 2, true); --answer_id 6
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'private (student) Flash 1 vastus', NULL, 3, true); --answer_id 7
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'private (student) Flash 2 vastus', NULL, 4, true); --answer_id 8
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'public Quiz 1 vastus A (vale)', NULL, 5, false); --answer_id 9
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'public Quiz 1 vastus B (vale)', NULL, 5, false); --answer_id 10
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'public Quiz 1 vastus C (oige)', NULL, 5, true); --answer_id 11
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'public Quiz 2 vastus A (vale)', NULL, 6, false); --answer_id 12
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'public Quiz 2 vastus B (vale)', NULL, 6, false); --answer_id 13
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'public Quiz 2 vastus C (oige)', NULL, 6, true); --answer_id 14
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'public Flash 1 vastus', NULL, 7, true); --answer_id 15
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'public Flash 2 vastus', NULL, 8, true); --answer_id 16


INSERT INTO public.quiz_question (id, quiz_id, question_id, status, timestamp) VALUES (DEFAULT, 1, 1, 'A', '2023-02-07 14:38:05.000000'); --quiz_question_id 1
INSERT INTO public.quiz_question (id, quiz_id, question_id, status, timestamp) VALUES (DEFAULT, 1, 2, 'A', '2023-02-07 14:38:06.000000'); --quiz_question_id 2
INSERT INTO public.quiz_question (id, quiz_id, question_id, status, timestamp) VALUES (DEFAULT, 2, 3, 'A', '2023-02-07 14:38:07.000000'); --quiz_question_id 3
INSERT INTO public.quiz_question (id, quiz_id, question_id, status, timestamp) VALUES (DEFAULT, 2, 4, 'A', '2023-02-07 14:38:08.000000'); --quiz_question_id 4
INSERT INTO public.quiz_question (id, quiz_id, question_id, status, timestamp) VALUES (DEFAULT, 3, 5, 'A', '2023-02-07 14:38:09.000000'); --quiz_question_id 5
INSERT INTO public.quiz_question (id, quiz_id, question_id, status, timestamp) VALUES (DEFAULT, 3, 6, 'A', '2023-02-07 14:38:10.000000'); --quiz_question_id 6
INSERT INTO public.quiz_question (id, quiz_id, question_id, status, timestamp) VALUES (DEFAULT, 4, 7, 'A', '2023-02-07 14:38:11.000000'); --quiz_question_id 7
INSERT INTO public.quiz_question (id, quiz_id, question_id, status, timestamp) VALUES (DEFAULT, 4, 8, 'A', '2023-02-07 14:38:12.000000'); --quiz_question_id 8


INSERT INTO public.counter (id, correct_count, quiz_question_id) VALUES (DEFAULT, 0, 1);
INSERT INTO public.counter (id, correct_count, quiz_question_id) VALUES (DEFAULT, 0, 2);
INSERT INTO public.counter (id, correct_count, quiz_question_id) VALUES (DEFAULT, 0, 3);
INSERT INTO public.counter (id, correct_count, quiz_question_id) VALUES (DEFAULT, 0, 4);
INSERT INTO public.counter (id, correct_count, quiz_question_id) VALUES (DEFAULT, 0, 5);
INSERT INTO public.counter (id, correct_count, quiz_question_id) VALUES (DEFAULT, 0, 6);
INSERT INTO public.counter (id, correct_count, quiz_question_id) VALUES (DEFAULT, 0, 7);
INSERT INTO public.counter (id, correct_count, quiz_question_id) VALUES (DEFAULT, 0, 8);
