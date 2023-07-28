-- ----------------------------
-- Table structure for mst_districts
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_districts";
CREATE TABLE "public"."mst_districts" (
    "district_id" int4 NOT NULL,
    "province_id" int4 NOT NULL,
    "district_code" varchar(3) COLLATE "pg_catalog"."default",
    "district_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "district_level" int2
)
;
COMMENT ON COLUMN "public"."mst_districts"."district_id" IS 'District ID';
COMMENT ON COLUMN "public"."mst_districts"."province_id" IS 'Province ID';
COMMENT ON COLUMN "public"."mst_districts"."district_code" IS 'District Code';
COMMENT ON COLUMN "public"."mst_districts"."district_name" IS 'District Name';
COMMENT ON COLUMN "public"."mst_districts"."district_level" IS '0: Quận, 1: Huyện, 2: Thành phố, 3: Thị xã';
COMMENT ON TABLE "public"."mst_districts" IS 'Quận/Huyện';

-- ----------------------------
-- Table structure for mst_provinces
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_provinces";
CREATE TABLE "public"."mst_provinces" (
    "province_id" int4 NOT NULL,
    "province_code" varchar(2) COLLATE "pg_catalog"."default" NOT NULL,
    "province_phone_code" varchar(3) COLLATE "pg_catalog"."default" NOT NULL,
    "province_license_plate" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "province_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "province_level" int2 NOT NULL
)
;
COMMENT ON COLUMN "public"."mst_provinces"."province_id" IS 'Province ID';
COMMENT ON COLUMN "public"."mst_provinces"."province_code" IS 'Province Code';
COMMENT ON COLUMN "public"."mst_provinces"."province_phone_code" IS 'Province Phone Code';
COMMENT ON COLUMN "public"."mst_provinces"."province_license_plate" IS 'Province License Plate';
COMMENT ON COLUMN "public"."mst_provinces"."province_name" IS 'Province Name';
COMMENT ON COLUMN "public"."mst_provinces"."province_level" IS '0: Thành phố Trung ương, 1: Tỉnh';
COMMENT ON TABLE "public"."mst_provinces" IS 'Tỉnh/Thành Phố';

-- ----------------------------
-- Table structure for mst_villages
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_villages";
CREATE TABLE "public"."mst_villages" (
    "village_id" int4 NOT NULL,
    "ward_id" int4 NOT NULL,
    "village_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;
COMMENT ON COLUMN "public"."mst_villages"."village_id" IS 'Village ID';
COMMENT ON COLUMN "public"."mst_villages"."ward_id" IS 'Ward ID';
COMMENT ON COLUMN "public"."mst_villages"."village_name" IS 'Village Name';
COMMENT ON TABLE "public"."mst_villages" IS 'Thôn/Xóm';

-- ----------------------------
-- Table structure for mst_wards
-- ----------------------------
DROP TABLE IF EXISTS "public"."mst_wards";
CREATE TABLE "public"."mst_wards" (
    "ward_id" int4 NOT NULL,
    "district_id" int4 NOT NULL,
    "ward_code" varchar(5) COLLATE "pg_catalog"."default",
    "ward_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
    "ward_level" int2
)
;
COMMENT ON COLUMN "public"."mst_wards"."ward_id" IS 'Commune ID';
COMMENT ON COLUMN "public"."mst_wards"."district_id" IS 'District ID';
COMMENT ON COLUMN "public"."mst_wards"."ward_code" IS 'Ward Code';
COMMENT ON COLUMN "public"."mst_wards"."ward_name" IS 'Commune Name';
COMMENT ON COLUMN "public"."mst_wards"."ward_level" IS '0: Phường, 1: Xã, 2: Thị trấn';
COMMENT ON TABLE "public"."mst_wards" IS 'Phường/Xã';

-- ----------------------------
-- Indexes structure for table mst_districts
-- ----------------------------
CREATE INDEX "district_code_index" ON "public"."mst_districts" USING btree (
    "district_code" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "province_id_index" ON "public"."mst_districts" USING btree (
    "province_id" "pg_catalog"."int4_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table mst_districts
-- ----------------------------
ALTER TABLE "public"."mst_districts" ADD CONSTRAINT "mst_districts_pkey" PRIMARY KEY ("district_id");

-- ----------------------------
-- Indexes structure for table mst_provinces
-- ----------------------------
CREATE INDEX "province_code_index" ON "public"."mst_provinces" USING btree (
    "province_code" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "province_license_plate_index" ON "public"."mst_provinces" USING btree (
    "province_license_plate" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "province_phone_code_index" ON "public"."mst_provinces" USING btree (
    "province_phone_code" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table mst_provinces
-- ----------------------------
ALTER TABLE "public"."mst_provinces" ADD CONSTRAINT "mst_provinces_pkey" PRIMARY KEY ("province_id");

-- ----------------------------
-- Indexes structure for table mst_villages
-- ----------------------------
CREATE INDEX "ward_id_index" ON "public"."mst_villages" USING btree (
    "ward_id" "pg_catalog"."int4_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table mst_villages
-- ----------------------------
ALTER TABLE "public"."mst_villages" ADD CONSTRAINT "mst_villages_pkey" PRIMARY KEY ("village_id");

-- ----------------------------
-- Indexes structure for table mst_wards
-- ----------------------------
CREATE INDEX "district_id_index" ON "public"."mst_wards" USING btree (
    "district_id" "pg_catalog"."int4_ops" ASC NULLS LAST
);
CREATE INDEX "ward_code_index" ON "public"."mst_wards" USING btree (
    "ward_code" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table mst_wards
-- ----------------------------
ALTER TABLE "public"."mst_wards" ADD CONSTRAINT "mst_wards_pkey" PRIMARY KEY ("ward_id");
