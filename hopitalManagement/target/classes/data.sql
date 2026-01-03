INSERT INTO patient(name, gender, birth_date, email, blood_group)
VALUES
    ('Jay Singh','Male','2002-08-15','jay17@gmail.com','O_POSITIVE'),
    ('Om Singh','Male','2006-06-23','om17@gmail.com','A_POSITIVE'),
    ('Shagan Sandhu','Female','2002-05-22','ss22@gmail.com','B_POSITIVE'),
    ('Veer Singh','Male','2002-10-15','veer07@gmail.com','O_POSITIVE'),
    ('Sanskar','Male','2002-12-22','ssG24@gmail.com','O_POSITIVE');


INSERT INTO doctor(name, specialization, email)
 VALUES
  ('Dr. Rakesh Mehta','Cardiology','rakesh.mehta@gmail.com'),
   ('Dr. Sneha Kapoor','Dermatology','sneha.kapoor@gmail.com'),
    ('Dr. Arjun Nair','Orthopedics','arjun.nair@gmail.com');


INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
('2026-01-10 09:30:00', 'General Checkup', 1, 2),
('2026-01-12 14:00:00', 'Skin Rash', 2, 2),
('2026-01-15 11:15:00', 'Knee Pain', 3, 3),
('2026-01-20 16:45:00', 'Follow-Up Visit', 1, 1),
 ('2026-01-25 10:00:00', 'Consultation', 1, 4),
 ('2026-02-01 13:30:00', 'Allergy Treatment ', 2, 5);

