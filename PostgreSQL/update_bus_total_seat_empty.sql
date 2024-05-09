CREATE OR REPLACE FUNCTION update_bus_total_seat_empty()
RETURNS TRIGGER AS $$
DECLARE
		v_total_seat_empty INT;
		v_bus_id INT;
BEGIN
		
		SELECT "BusId"
		INTO v_bus_id
		FROM "Reservation" R INNER JOIN "Bus" B ON R."BusId" = B."BusId"
		WHERE R."ReservationId" = NEW."ReservationId";
		
		SELECT count(*)
		FROM "Invoice" I INNER JOIN "Reservation" R ON I."ReservationId" = R."ReservationId"
		INNER JOIN "Bus" B ON R."BusId" = B."BusId"
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_total_seat_empty_trigger
AFTER INSERT OR UPDATE ON Invoice
FOR EACH ROW
EXECUTE FUNCTION update_bus_total_seat_empty();