create database task;

        use task;

        create table employee(
        emp_no int,
        birth_date date,
        first_name varchar(15),
        last_name varchar(40),
        gender enum('F','M'),
        hire_date date
        );

        insert into employee values
        (10001,'1953-09-02','Georgo','Facello','M','1986-06-26'),
        (10002,'1964-06-02','Bezalel','Simmel','F','1985-11-21'),
        (10003,'1959-12-03','Parto','Bamford','M','1986-08-28'),
        (10004,'1954-05-01','Christian','Koblick','M','1986-12-01');

        select* from employee where hire_date = (select max(hire_date) from employee);

        +--------+------------+------------+-----------+--------+------------+
        | emp_no | birth_date | first_name | last_name | gender | hire_date  |
        +--------+------------+------------+-----------+--------+------------+
        |  10004 | 1954-05-01 | Christian  | Koblick   | M      | 1986-12-01 |
        +--------+------------+------------+-----------+--------+------------+


        select film.film_id,title
        from film
        where film.film_id not in(select film_id from film_category);

        select film.film_id,title
        from film left join film_category on film.film_id = film_category.film_id
        where film_category.film_id is null;

        +---------+------------------+
        | film_id | title            |
        +---------+------------------+
        |       3 | ADAPTATION HOLES |
        +---------+------------------+




        select * from employees limit 5,5;

        +--------+------------+------------+-----------+--------+------------+
        | emp_no | birth_date | first_name | last_name | gender | hire_date  |
        +--------+------------+------------+-----------+--------+------------+
        |  10006 | 1953-04-20 | Anneke     | Preusig   | F      | 1989-06-02 |
        |  10007 | 1957-05-23 | Tzvetan    | Zielinski | F      | 1989-02-10 |
        |  10008 | 1958-02-19 | Saniya     | Kalloufi  | M      | 1994-09-15 |
        |  10009 | 1952-04-19 | Sumant     | Peac      | F      | 1985-02-18 |
        |  10010 | 1963-06-01 | Duangkaew  | Piveteau  | F      | 1989-08-24 |
        +--------+------------+------------+-----------+--------+------------+



        alter table actor add unique index uniq_idx_firstname(first_name);

        mysql> alter table actor add index idx_lastnam(last_name);

        mysql> show index from actor\g;
        +-------+------------+--------------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+
        | Table | Non_unique | Key_name           | Seq_in_index | Column_name | Collation | Cardinality | Sub_part | Packed | Null | Index_type | Comment | Index_comment | Visible | Expression |
        +-------+------------+--------------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+
        | actor |          0 | PRIMARY            |            1 | actor_id    | A         |           0 |     NULL |   NULL |      | BTREE      |         |               | YES     | NULL       |
        | actor |          0 | uniq_idx_firstname |            1 | first_name  | A         |           0 |     NULL |   NULL |      | BTREE      |         |               | YES     | NULL       |
        | actor |          1 | idx_lastnam        |            1 | last_name   | A         |           0 |     NULL |   NULL |      | BTREE      |         |               | YES     | NULL       |
        +-------+------------+--------------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+






        select
        a.id,
        a.number,
        (select count(distinct b.number) from pn b where b.number>=a.number ) t_rank
        from pn a
        order by a.number desc, a.id asc;
        +------+--------+--------+
        | id   | number | t_rank |
        +------+--------+--------+
        |    5 |      5 |      1 |
        |    1 |      4 |      2 |
        |    6 |      4 |      2 |
        |    2 |      3 |      3 |
        |    3 |      3 |      3 |
        |    4 |      2 |      4 |
        +------+--------+--------+


