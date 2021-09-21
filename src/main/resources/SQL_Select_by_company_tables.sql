create table company(
	id integer not null,
	name character varying,
	constraint company_pkey primary key(id)
);

create table person(
	id integer not null,
	name character varying,
	company_id integer references company(id),
	constraint person_pkey primary key(id)
);