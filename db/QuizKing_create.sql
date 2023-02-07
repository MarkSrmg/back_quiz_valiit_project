-- tables
-- Table: answer
CREATE TABLE answer (
    id serial  NOT NULL,
    text varchar(500)  NULL,
    picture bytea  NULL,
    question_id int  NOT NULL,
    is_correct boolean  NOT NULL,
    CONSTRAINT answer_pk PRIMARY KEY (id)
);

-- Table: counter
CREATE TABLE counter (
    id serial  NOT NULL,
    correct_count int  NOT NULL,
    quiz_question_id int  NOT NULL,
    CONSTRAINT counter_pk PRIMARY KEY (id)
);

-- Table: question
CREATE TABLE question (
    id serial  NOT NULL,
    text varchar(500)  NOT NULL,
    picture bytea  NULL,
    type char(1)  NOT NULL,
    CONSTRAINT question_pk PRIMARY KEY (id)
);

-- Table: quiz
CREATE TABLE quiz (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    name varchar(255)  NOT NULL,
    status char(1)  NOT NULL,
    public boolean  NOT NULL,
    required_count int  NOT NULL,
    type char(1)  NOT NULL,
    timestamp timestamp  NOT NULL,
    CONSTRAINT quiz_pk PRIMARY KEY (id)
);

-- Table: quiz_question
CREATE TABLE quiz_question (
    id serial  NOT NULL,
    quiz_id int  NOT NULL,
    question_id int  NOT NULL,
    status char(1)  NOT NULL,
    timestamp timestamp  NOT NULL,
    CONSTRAINT quiz_question_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    role_id int  NOT NULL,
    username varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT username UNIQUE (username) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: answer_question (table: answer)
ALTER TABLE answer ADD CONSTRAINT answer_question
    FOREIGN KEY (question_id)
    REFERENCES question (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: counter_quiz_question (table: counter)
ALTER TABLE counter ADD CONSTRAINT counter_quiz_question
    FOREIGN KEY (quiz_question_id)
    REFERENCES quiz_question (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: quiz_question_question (table: quiz_question)
ALTER TABLE quiz_question ADD CONSTRAINT quiz_question_question
    FOREIGN KEY (question_id)
    REFERENCES question (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: quiz_question_quiz (table: quiz_question)
ALTER TABLE quiz_question ADD CONSTRAINT quiz_question_quiz
    FOREIGN KEY (quiz_id)
    REFERENCES quiz (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: quiz_user (table: quiz)
ALTER TABLE quiz ADD CONSTRAINT quiz_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

