/*
	Hưng Phạm
	SELECT * FROM get_info_user_by_user_id(1)
*/
CREATE OR REPLACE FUNCTION get_info_user_by_user_id
(
	p_user_id INT
)
RETURNS TABLE(
	"FullName" VARCHAR,
	"SDT" VARCHAR,
	"Address" VARCHAR,
	"Username" VARCHAR,
	"Password" VARCHAR,
	"RoleId" INT,
	"RoleName" VARCHAR,
	"PartnerId" INT,
	"PartnerName" VARCHAR
) AS $BODY$
BEGIN

	RETURN QUERY
	SELECT
		U."FullName",
		U."SDT",
		U."Address",
		ACC."Username",
		ACC."Password",
		R."RoleId",
		R."RoleName",
		P."PartnerId",
		P."PartnerName"
	FROM "User" U INNER JOIN "Account" ACC ON U."UserId" = ACC."UserId"
	INNER JOIN "Role" R ON R."RoleId" = ACC."RoleId"
	INNER JOIN "Partner" P ON ACC."PartnerId" = P."PartnerId"
	WHERE U."UserId" = p_user_id;
	
END;
$BODY$
LANGUAGE plpgsql VOLATILE