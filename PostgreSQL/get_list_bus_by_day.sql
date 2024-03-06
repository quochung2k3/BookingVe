/*
	Hưng Phạm
	SELECT * FROM get_list_bus_by_day('2024-03-06', 1, 2)
*/
-- DROP FUNCTION get_list_bus_by_day
CREATE OR REPLACE FUNCTION get_list_bus_by_day
(
	p_going_date DATE,
	p_start_id INT,
	p_end_id INT
)
RETURNS TABLE(
	"BusId" INT,
	"VehicleId" INT,
	"VehicleName" VARCHAR,
	"GoingDateTime" TIMESTAMP,
	"SeatsOfBusId" INT,
	"Quantity" INT,
	"BusTypeId" INT,
	"BusTypeName" VARCHAR,
	"PlaceStartId" INT,
	"PlaceStartName" VARCHAR,
	"PlaceEndId" INT,
	"PlaceEndName" VARCHAR,
	"Price" INT
) AS $BODY$
DECLARE 
	v_title_ids INT[];
BEGIN

	RETURN QUERY
	SELECT
		b."BusId",
		b."VehicleId",
		b."VehicleName",
		b."GoingDateTime",
		b."SeatsOfBusId",
		sob."Quantity",
		b."BusTypeId",
		bt."BusTypeName",
		b."PlaceStartId",
		b."PlaceStartName",
		b."PlaceEndId",
		b."PlaceEndName",
		st."Price"
	FROM "Bus" b INNER JOIN "BusType" bt ON b."BusTypeId" = bt."BusTypeId"
	INNER JOIN "SeatsOfBus" sob ON sob."SeatsOfBusId" = b."SeatsOfBusId"
	INNER JOIN "Seat" s ON s."BusTypeId" = b."BusTypeId"
	INNER JOIN "SeatType" st ON s."SeatTypeId" = st."SeatTypeId"
	WHERE b."GoingDateTime"::DATE = p_going_date
	AND b."PlaceStartId" = p_start_id
	AND b."PlaceEndId" = p_end_id;
END;
$BODY$
LANGUAGE plpgsql VOLATILE