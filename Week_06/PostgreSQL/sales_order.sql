
-- ----------------------------
-- Table structure for sales_order
-- ----------------------------
DROP TABLE IF EXISTS "public"."sales_order";
CREATE TABLE "public"."sales_order" (
  "id" int8 NOT NULL,
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "created_date_time" timestamp(6),
  "deleted" bool,
  "last_modified_by" varchar(64) COLLATE "pg_catalog"."default",
  "last_modified_date_time" timestamp(6),
  "name" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "tenant_id" varchar(255) COLLATE "pg_catalog"."default",
  "version" int4,
  "customer_id" int8,
  "mobile" varchar(255) COLLATE "pg_catalog"."default",
  "shipping_address" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."sales_order" OWNER TO "postgres";

-- ----------------------------
-- Primary Key structure for table sales_order
-- ----------------------------
ALTER TABLE "public"."sales_order" ADD CONSTRAINT "sales_order_pkey" PRIMARY KEY ("id");
