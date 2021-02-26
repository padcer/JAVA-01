
-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS "public"."customer";
CREATE TABLE "public"."customer" (
  "id" int8 NOT NULL,
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "created_date_time" timestamp(6),
  "deleted" bool,
  "last_modified_by" varchar(64) COLLATE "pg_catalog"."default",
  "last_modified_date_time" timestamp(6),
  "name" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "tenant_id" varchar(255) COLLATE "pg_catalog"."default",
  "version" int4,
  "mobile" varchar(255) COLLATE "pg_catalog"."default",
  "shipping_address" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."customer" OWNER TO "postgres";

-- ----------------------------
-- Primary Key structure for table customer
-- ----------------------------
ALTER TABLE "public"."customer" ADD CONSTRAINT "customer_pkey" PRIMARY KEY ("id");
