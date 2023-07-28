-- ----------------------------
-- Table structure for api_traffic
-- ----------------------------
DROP TABLE IF EXISTS "public"."api_traffic";
CREATE TABLE "public"."api_traffic" (
    "id" SERIAL NOT NULL,
    "api_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "total_use" int4 NOT NULL
);

COMMENT ON COLUMN "public"."api_traffic"."id" IS 'ID';
COMMENT ON COLUMN "public"."api_traffic"."api_name" IS 'Api Name';
COMMENT ON COLUMN "public"."api_traffic"."total_use" IS 'Total Use';

-- ----------------------------
-- Indexes structure for table api_traffic
-- ----------------------------
CREATE UNIQUE INDEX "api_name_index" ON "public"."api_traffic" USING btree (
    "api_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table api_traffic
-- ----------------------------
ALTER TABLE "public"."api_traffic" ADD CONSTRAINT "api_traffic_pkey" PRIMARY KEY ("id");
