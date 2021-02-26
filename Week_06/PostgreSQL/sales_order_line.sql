
-- ----------------------------
-- Table structure for sales_order_line
-- ----------------------------
DROP TABLE IF EXISTS "public"."sales_order_line";
CREATE TABLE "public"."sales_order_line" (
  "id" int8 NOT NULL,
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "created_date_time" timestamp(6),
  "deleted" bool,
  "last_modified_by" varchar(64) COLLATE "pg_catalog"."default",
  "last_modified_date_time" timestamp(6),
  "name" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "tenant_id" varchar(255) COLLATE "pg_catalog"."default",
  "version" int4,
  "category_id" int8,
  "order_id" int8,
  "product_id" int8,
  "product_name" varchar(255) COLLATE "pg_catalog"."default",
  "sequence" int4
)
;
ALTER TABLE "public"."sales_order_line" OWNER TO "postgres";

-- ----------------------------
-- Primary Key structure for table sales_order_line
-- ----------------------------
ALTER TABLE "public"."sales_order_line" ADD CONSTRAINT "sales_order_line_pkey" PRIMARY KEY ("id");
