
-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS "public"."product";
CREATE TABLE "public"."product" (
  "id" int8 NOT NULL,
  "create_by" varchar(64) COLLATE "pg_catalog"."default",
  "created_date_time" timestamp(6),
  "deleted" bool,
  "last_modified_by" varchar(64) COLLATE "pg_catalog"."default",
  "last_modified_date_time" timestamp(6),
  "name" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "tenant_id" varchar(255) COLLATE "pg_catalog"."default",
  "version" int4,
  "category_id" int8
)
;
ALTER TABLE "public"."product" OWNER TO "postgres";

-- ----------------------------
-- Primary Key structure for table product
-- ----------------------------
ALTER TABLE "public"."product" ADD CONSTRAINT "product_pkey" PRIMARY KEY ("id");
