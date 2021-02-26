
-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS "public"."product_category";
CREATE TABLE "public"."product_category" (
  "id" int8 NOT NULL,
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "created_date_time" timestamp(6),
  "deleted" bool,
  "last_modified_by" varchar(64) COLLATE "pg_catalog"."default",
  "last_modified_date_time" timestamp(6),
  "name" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "tenant_id" varchar(255) COLLATE "pg_catalog"."default",
  "version" int4
)
;
ALTER TABLE "public"."product_category" OWNER TO "postgres";

-- ----------------------------
-- Primary Key structure for table product_category
-- ----------------------------
ALTER TABLE "public"."product_category" ADD CONSTRAINT "product_category_pkey" PRIMARY KEY ("id");
