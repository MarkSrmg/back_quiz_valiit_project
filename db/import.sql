INSERT INTO public.role (id, name) VALUES (DEFAULT, 'student');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'teacher');

INSERT INTO public.user (id, role_id, username, password, status) VALUES (DEFAULT, 1, 'student', '123', 'A');
INSERT INTO public.user (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'teacher', '123', 'A');

INSERT INTO public.quiz (id, user_id, name, status, public, required_count, type, timestamp) VALUES (DEFAULT, 2, 'public quiz', 'A', true, 2, 'F', '2023-02-07 14:37:04.000000');
INSERT INTO public.quiz (id, user_id, name, status, public, required_count, type, timestamp) VALUES (DEFAULT, 1, 'flashy', 'A', false, 2, 'F', '2023-02-07 14:36:14.000000');
INSERT INTO public.quiz (id, user_id, name, status, public, required_count, type, timestamp) VALUES (DEFAULT, 1, 'quizzy', 'A', false, 2, 'Q', '2023-02-07 14:38:08.000000');

INSERT INTO public.question (id, text, picture, type) VALUES (DEFAULT, 'flashcard 1 kysimus', NULL, 'F');
INSERT INTO public.question (id, text, picture, type) VALUES (DEFAULT, 'flashcard 2 student kysimus', NULL, 'F');

INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'Flashcard answer 1', NULL, 1, true);
INSERT INTO public.answer (id, text, picture, question_id, is_correct) VALUES (DEFAULT, 'Flashcard answer 2', NULL, 2, true);

INSERT INTO public.quiz_question (id, quiz_id, question_id, status, timestamp) VALUES (DEFAULT, 2, 1, 'A', '2023-02-07 14:43:19.000000');
INSERT INTO public.quiz_question (id, quiz_id, question_id, status, timestamp) VALUES (DEFAULT, 2, 2, 'A', '2023-02-07 14:43:31.000000');

INSERT INTO public.counter (id, correct_count, quiz_question_id) VALUES (DEFAULT, 0, 1);
INSERT INTO public.counter (id, correct_count, quiz_question_id) VALUES (DEFAULT, 0, 2);
