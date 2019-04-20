package qy.lab.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

public interface LabRepository extends JpaRepository<Person, Long> {
}
