/*
1. В одном запросе получить
- имена всех person, которые не состоят в компании с id = 5;
- название компании для каждого человека.*/
select p.name, c.name from person as p
join company c on p.company_id = c.id where p.company_id != 5;
/*
2. Необходимо выбрать название компании с максимальным количеством человек 
+ количество человек в этой компании.
*/
select c.name as CompanyName, count(p.name) as numemployees 
from company c join person p on c.id = p.company_id
group by c.name
order by count(p.name) desc limit 1;
