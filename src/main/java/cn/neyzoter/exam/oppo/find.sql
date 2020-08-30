问题1
select stu_no, stu_name, class_name from t_student s left join t_class c on s.class_id = c.id;

问题2
select class_no, class_name, count(class_no) stu_count from t_class c left join t_student s on c.id = s.id group by class_no
