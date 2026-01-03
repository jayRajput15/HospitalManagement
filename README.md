Key Highlights

Advanced JPA Mapping: Showcases one-to-one, one-to-many, and many-to-many relationships between core entities such as Patient, Doctor, Appointment, and Insurance.

Bidirectional Consistency: Demonstrates how to maintain synchronization between entities (e.g., assigning insurance to a patient or reassigning appointments to different doctors).

Cascade Operations & Orphan Removal: Explains how deleting a patient can automatically handle related appointments and insurance records.

Transactional Safety: Uses @Transactional to ensure atomic operations and prevent lazy initialization errors.

Educational Focus: Built as a teaching tool to make developers comfortable with advanced ORM concepts, bridging the gap between theory and practice.


Entities Modeled


Patient: Holds personal and medical details, linked to appointments and insurance.

Doctor: Specializations and schedules, connected to multiple appointments.

Appointment: Acts as a bridge between patients and doctors, with time and reason fields.

Insurance: One-to-one mapping with patients, demonstrating bidirectional consistency.

Purpose


This setup is not just about building a hospital management service — it’s about explaining and demonstrating advanced JPA mapping methodology in a clear, practical way. By working through this project, developers gain hands-on experience with entity design, relationship management, and persistence best practices.
