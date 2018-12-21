package io.openems.edge.battery.soltaro;

import java.util.Arrays;
import java.util.stream.Stream;

import io.openems.edge.battery.api.Battery;
import io.openems.edge.common.channel.AbstractReadChannel;
import io.openems.edge.common.channel.BooleanReadChannel;
import io.openems.edge.common.channel.IntegerReadChannel;
import io.openems.edge.common.channel.IntegerWriteChannel;
import io.openems.edge.common.channel.StateChannel;
import io.openems.edge.common.channel.StateCollectorChannel;
import io.openems.edge.common.component.OpenemsComponent;

public class Utils {
	public static Stream<? extends AbstractReadChannel<?>> initializeChannels(SoltaroRack s) {
		// Define the channels. Using streams + switch enables Eclipse IDE to tell us if
		// we are missing an Enum value.
		return Stream.of( //
				Arrays.stream(OpenemsComponent.ChannelId.values()).map(channelId -> {
					switch (channelId) {
					case STATE:
						return new StateCollectorChannel(s, channelId);
					}
					return null;
				}), Arrays.stream(Battery.ChannelId.values()).map(channelId -> {
					switch (channelId) {
					case SOC:
					case SOH:
					case CAPACITY:
					case VOLTAGE:
					case CURRENT:
					case MAX_CELL_TEMPERATURE:
					case MAX_CELL_VOLTAGE:
					case MIN_CELL_TEMPERATURE:
					case MIN_CELL_VOLTAGE:
					case MAX_POWER:			
						return new IntegerReadChannel(s, channelId);
					case CHARGE_MAX_CURRENT:
						return new IntegerReadChannel(s, channelId, SoltaroRack.CHARGE_MAX_A);
					case CHARGE_MAX_VOLTAGE:
						return new IntegerReadChannel(s, channelId, SoltaroRack.CHARGE_MAX_V);
					case DISCHARGE_MAX_CURRENT:
						return new IntegerReadChannel(s, channelId, SoltaroRack.DISCHARGE_MAX_A);
					case DISCHARGE_MIN_VOLTAGE:
						return new IntegerReadChannel(s, channelId, SoltaroRack.DISCHARGE_MIN_V);
					case READY_FOR_WORKING:
						return new BooleanReadChannel(s, channelId);
					default:
						break;
					}
					return null;
				}), Arrays.stream(SoltaroRack.ChannelId.values()).map(channelId -> {
					switch (channelId) {
					case BMS_CONTACTOR_CONTROL:
					case CELL_VOLTAGE_PROTECT:
					case CELL_VOLTAGE_RECOVER:
						return new IntegerWriteChannel(s, channelId);

					case ALARM_LEVEL_1_CELL_CHA_TEMP_HIGH:
					case ALARM_LEVEL_1_CELL_CHA_TEMP_LOW:
					case ALARM_LEVEL_1_CELL_DISCHA_TEMP_HIGH:
					case ALARM_LEVEL_1_CELL_DISCHA_TEMP_LOW:
					case ALARM_LEVEL_1_CELL_TEMP_DIFF_HIGH:
					case ALARM_LEVEL_1_CELL_VOLTAGE_DIFF_HIGH:
					case ALARM_LEVEL_1_CELL_VOLTAGE_HIGH:
					case ALARM_LEVEL_1_CELL_VOLTAGE_LOW:
					case ALARM_LEVEL_1_CHA_CURRENT_HIGH:
					case ALARM_LEVEL_1_DISCHA_CURRENT_HIGH:
					case ALARM_LEVEL_1_INSULATION_LOW:
					case ALARM_LEVEL_1_SOC_LOW:
					case ALARM_LEVEL_1_TOTAL_VOLTAGE_DIFF_HIGH:
					case ALARM_LEVEL_1_TOTAL_VOLTAGE_HIGH:
					case ALARM_LEVEL_1_TOTAL_VOLTAGE_LOW:
					case ALARM_LEVEL_2_CELL_CHA_TEMP_HIGH:
					case ALARM_LEVEL_2_CELL_CHA_TEMP_LOW:
					case ALARM_LEVEL_2_CELL_DISCHA_TEMP_HIGH:
					case ALARM_LEVEL_2_CELL_DISCHA_TEMP_LOW:
					case ALARM_LEVEL_2_CELL_VOLTAGE_HIGH:
					case ALARM_LEVEL_2_CELL_VOLTAGE_LOW:
					case ALARM_LEVEL_2_CHA_CURRENT_HIGH:
					case ALARM_LEVEL_2_DISCHA_CURRENT_HIGH:
					case ALARM_LEVEL_2_INSULATION_LOW:
					case ALARM_LEVEL_2_TOTAL_VOLTAGE_HIGH:
					case ALARM_LEVEL_2_TOTAL_VOLTAGE_LOW:

					case FAILURE_BALANCING_MODULE:
					case FAILURE_CONNECTOR_WIRE:
					case FAILURE_EEPROM:
					case FAILURE_INITIALIZATION:
					case FAILURE_INTRANET_COMMUNICATION:
					case FAILURE_LTC6803:
					case FAILURE_SAMPLING_WIRE:
					case FAILURE_TEMP_SAMPLING:
					case FAILURE_TEMP_SAMPLING_LINE:
					case FAILURE_TEMP_SENSOR:
					case FAILURE_VOLTAGE_SAMPLING:

					case PRECHARGE_TAKING_TOO_LONG:
						return new StateChannel(s, channelId);
					case CLUSTER_1_BATTERY_000_VOLTAGE:
					case CLUSTER_1_BATTERY_001_VOLTAGE:
					case CLUSTER_1_BATTERY_002_VOLTAGE:
					case CLUSTER_1_BATTERY_003_VOLTAGE:
					case CLUSTER_1_BATTERY_004_VOLTAGE:
					case CLUSTER_1_BATTERY_005_VOLTAGE:
					case CLUSTER_1_BATTERY_006_VOLTAGE:
					case CLUSTER_1_BATTERY_007_VOLTAGE:
					case CLUSTER_1_BATTERY_008_VOLTAGE:
					case CLUSTER_1_BATTERY_009_VOLTAGE:
					case CLUSTER_1_BATTERY_010_VOLTAGE:
					case CLUSTER_1_BATTERY_011_VOLTAGE:
					case CLUSTER_1_BATTERY_012_VOLTAGE:
					case CLUSTER_1_BATTERY_013_VOLTAGE:
					case CLUSTER_1_BATTERY_014_VOLTAGE:
					case CLUSTER_1_BATTERY_015_VOLTAGE:
					case CLUSTER_1_BATTERY_016_VOLTAGE:
					case CLUSTER_1_BATTERY_017_VOLTAGE:
					case CLUSTER_1_BATTERY_018_VOLTAGE:
					case CLUSTER_1_BATTERY_019_VOLTAGE:
					case CLUSTER_1_BATTERY_020_VOLTAGE:
					case CLUSTER_1_BATTERY_021_VOLTAGE:
					case CLUSTER_1_BATTERY_022_VOLTAGE:
					case CLUSTER_1_BATTERY_023_VOLTAGE:
					case CLUSTER_1_BATTERY_024_VOLTAGE:
					case CLUSTER_1_BATTERY_025_VOLTAGE:
					case CLUSTER_1_BATTERY_026_VOLTAGE:
					case CLUSTER_1_BATTERY_027_VOLTAGE:
					case CLUSTER_1_BATTERY_028_VOLTAGE:
					case CLUSTER_1_BATTERY_029_VOLTAGE:
					case CLUSTER_1_BATTERY_030_VOLTAGE:
					case CLUSTER_1_BATTERY_031_VOLTAGE:
					case CLUSTER_1_BATTERY_032_VOLTAGE:
					case CLUSTER_1_BATTERY_033_VOLTAGE:
					case CLUSTER_1_BATTERY_034_VOLTAGE:
					case CLUSTER_1_BATTERY_035_VOLTAGE:
					case CLUSTER_1_BATTERY_036_VOLTAGE:
					case CLUSTER_1_BATTERY_037_VOLTAGE:
					case CLUSTER_1_BATTERY_038_VOLTAGE:
					case CLUSTER_1_BATTERY_039_VOLTAGE:
					case CLUSTER_1_BATTERY_040_VOLTAGE:
					case CLUSTER_1_BATTERY_041_VOLTAGE:
					case CLUSTER_1_BATTERY_042_VOLTAGE:
					case CLUSTER_1_BATTERY_043_VOLTAGE:
					case CLUSTER_1_BATTERY_044_VOLTAGE:
					case CLUSTER_1_BATTERY_045_VOLTAGE:
					case CLUSTER_1_BATTERY_046_VOLTAGE:
					case CLUSTER_1_BATTERY_047_VOLTAGE:
					case CLUSTER_1_BATTERY_048_VOLTAGE:
					case CLUSTER_1_BATTERY_049_VOLTAGE:
					case CLUSTER_1_BATTERY_050_VOLTAGE:
					case CLUSTER_1_BATTERY_051_VOLTAGE:
					case CLUSTER_1_BATTERY_052_VOLTAGE:
					case CLUSTER_1_BATTERY_053_VOLTAGE:
					case CLUSTER_1_BATTERY_054_VOLTAGE:
					case CLUSTER_1_BATTERY_055_VOLTAGE:
					case CLUSTER_1_BATTERY_056_VOLTAGE:
					case CLUSTER_1_BATTERY_057_VOLTAGE:
					case CLUSTER_1_BATTERY_058_VOLTAGE:
					case CLUSTER_1_BATTERY_059_VOLTAGE:
					case CLUSTER_1_BATTERY_060_VOLTAGE:
					case CLUSTER_1_BATTERY_061_VOLTAGE:
					case CLUSTER_1_BATTERY_062_VOLTAGE:
					case CLUSTER_1_BATTERY_063_VOLTAGE:
					case CLUSTER_1_BATTERY_064_VOLTAGE:
					case CLUSTER_1_BATTERY_065_VOLTAGE:
					case CLUSTER_1_BATTERY_066_VOLTAGE:
					case CLUSTER_1_BATTERY_067_VOLTAGE:
					case CLUSTER_1_BATTERY_068_VOLTAGE:
					case CLUSTER_1_BATTERY_069_VOLTAGE:
					case CLUSTER_1_BATTERY_070_VOLTAGE:
					case CLUSTER_1_BATTERY_071_VOLTAGE:
					case CLUSTER_1_BATTERY_072_VOLTAGE:
					case CLUSTER_1_BATTERY_073_VOLTAGE:
					case CLUSTER_1_BATTERY_074_VOLTAGE:
					case CLUSTER_1_BATTERY_075_VOLTAGE:
					case CLUSTER_1_BATTERY_076_VOLTAGE:
					case CLUSTER_1_BATTERY_077_VOLTAGE:
					case CLUSTER_1_BATTERY_078_VOLTAGE:
					case CLUSTER_1_BATTERY_079_VOLTAGE:
					case CLUSTER_1_BATTERY_080_VOLTAGE:
					case CLUSTER_1_BATTERY_081_VOLTAGE:
					case CLUSTER_1_BATTERY_082_VOLTAGE:
					case CLUSTER_1_BATTERY_083_VOLTAGE:
					case CLUSTER_1_BATTERY_084_VOLTAGE:
					case CLUSTER_1_BATTERY_085_VOLTAGE:
					case CLUSTER_1_BATTERY_086_VOLTAGE:
					case CLUSTER_1_BATTERY_087_VOLTAGE:
					case CLUSTER_1_BATTERY_088_VOLTAGE:
					case CLUSTER_1_BATTERY_089_VOLTAGE:
					case CLUSTER_1_BATTERY_090_VOLTAGE:
					case CLUSTER_1_BATTERY_091_VOLTAGE:
					case CLUSTER_1_BATTERY_092_VOLTAGE:
					case CLUSTER_1_BATTERY_093_VOLTAGE:
					case CLUSTER_1_BATTERY_094_VOLTAGE:
					case CLUSTER_1_BATTERY_095_VOLTAGE:
					case CLUSTER_1_BATTERY_096_VOLTAGE:
					case CLUSTER_1_BATTERY_097_VOLTAGE:
					case CLUSTER_1_BATTERY_098_VOLTAGE:
					case CLUSTER_1_BATTERY_099_VOLTAGE:
					case CLUSTER_1_BATTERY_100_VOLTAGE:
					case CLUSTER_1_BATTERY_101_VOLTAGE:
					case CLUSTER_1_BATTERY_102_VOLTAGE:
					case CLUSTER_1_BATTERY_103_VOLTAGE:
					case CLUSTER_1_BATTERY_104_VOLTAGE:
					case CLUSTER_1_BATTERY_105_VOLTAGE:
					case CLUSTER_1_BATTERY_106_VOLTAGE:
					case CLUSTER_1_BATTERY_107_VOLTAGE:
					case CLUSTER_1_BATTERY_108_VOLTAGE:
					case CLUSTER_1_BATTERY_109_VOLTAGE:
					case CLUSTER_1_BATTERY_110_VOLTAGE:
					case CLUSTER_1_BATTERY_111_VOLTAGE:
					case CLUSTER_1_BATTERY_112_VOLTAGE:
					case CLUSTER_1_BATTERY_113_VOLTAGE:
					case CLUSTER_1_BATTERY_114_VOLTAGE:
					case CLUSTER_1_BATTERY_115_VOLTAGE:
					case CLUSTER_1_BATTERY_116_VOLTAGE:
					case CLUSTER_1_BATTERY_117_VOLTAGE:
					case CLUSTER_1_BATTERY_118_VOLTAGE:
					case CLUSTER_1_BATTERY_119_VOLTAGE:
					case CLUSTER_1_BATTERY_120_VOLTAGE:
					case CLUSTER_1_BATTERY_121_VOLTAGE:
					case CLUSTER_1_BATTERY_122_VOLTAGE:
					case CLUSTER_1_BATTERY_123_VOLTAGE:
					case CLUSTER_1_BATTERY_124_VOLTAGE:
					case CLUSTER_1_BATTERY_125_VOLTAGE:
					case CLUSTER_1_BATTERY_126_VOLTAGE:
					case CLUSTER_1_BATTERY_127_VOLTAGE:
					case CLUSTER_1_BATTERY_128_VOLTAGE:
					case CLUSTER_1_BATTERY_129_VOLTAGE:
					case CLUSTER_1_BATTERY_130_VOLTAGE:
					case CLUSTER_1_BATTERY_131_VOLTAGE:
					case CLUSTER_1_BATTERY_132_VOLTAGE:
					case CLUSTER_1_BATTERY_133_VOLTAGE:
					case CLUSTER_1_BATTERY_134_VOLTAGE:
					case CLUSTER_1_BATTERY_135_VOLTAGE:
					case CLUSTER_1_BATTERY_136_VOLTAGE:
					case CLUSTER_1_BATTERY_137_VOLTAGE:
					case CLUSTER_1_BATTERY_138_VOLTAGE:
					case CLUSTER_1_BATTERY_139_VOLTAGE:
					case CLUSTER_1_BATTERY_140_VOLTAGE:
					case CLUSTER_1_BATTERY_141_VOLTAGE:
					case CLUSTER_1_BATTERY_142_VOLTAGE:
					case CLUSTER_1_BATTERY_143_VOLTAGE:
					case CLUSTER_1_BATTERY_144_VOLTAGE:
					case CLUSTER_1_BATTERY_145_VOLTAGE:
					case CLUSTER_1_BATTERY_146_VOLTAGE:
					case CLUSTER_1_BATTERY_147_VOLTAGE:
					case CLUSTER_1_BATTERY_148_VOLTAGE:
					case CLUSTER_1_BATTERY_149_VOLTAGE:
					case CLUSTER_1_BATTERY_150_VOLTAGE:
					case CLUSTER_1_BATTERY_151_VOLTAGE:
					case CLUSTER_1_BATTERY_152_VOLTAGE:
					case CLUSTER_1_BATTERY_153_VOLTAGE:
					case CLUSTER_1_BATTERY_154_VOLTAGE:
					case CLUSTER_1_BATTERY_155_VOLTAGE:
					case CLUSTER_1_BATTERY_156_VOLTAGE:
					case CLUSTER_1_BATTERY_157_VOLTAGE:
					case CLUSTER_1_BATTERY_158_VOLTAGE:
					case CLUSTER_1_BATTERY_159_VOLTAGE:
					case CLUSTER_1_BATTERY_160_VOLTAGE:
					case CLUSTER_1_BATTERY_161_VOLTAGE:
					case CLUSTER_1_BATTERY_162_VOLTAGE:
					case CLUSTER_1_BATTERY_163_VOLTAGE:
					case CLUSTER_1_BATTERY_164_VOLTAGE:
					case CLUSTER_1_BATTERY_165_VOLTAGE:
					case CLUSTER_1_BATTERY_166_VOLTAGE:
					case CLUSTER_1_BATTERY_167_VOLTAGE:
					case CLUSTER_1_BATTERY_168_VOLTAGE:
					case CLUSTER_1_BATTERY_169_VOLTAGE:
					case CLUSTER_1_BATTERY_170_VOLTAGE:
					case CLUSTER_1_BATTERY_171_VOLTAGE:
					case CLUSTER_1_BATTERY_172_VOLTAGE:
					case CLUSTER_1_BATTERY_173_VOLTAGE:
					case CLUSTER_1_BATTERY_174_VOLTAGE:
					case CLUSTER_1_BATTERY_175_VOLTAGE:
					case CLUSTER_1_BATTERY_176_VOLTAGE:
					case CLUSTER_1_BATTERY_177_VOLTAGE:
					case CLUSTER_1_BATTERY_178_VOLTAGE:
					case CLUSTER_1_BATTERY_179_VOLTAGE:
					case CLUSTER_1_BATTERY_180_VOLTAGE:
					case CLUSTER_1_BATTERY_181_VOLTAGE:
					case CLUSTER_1_BATTERY_182_VOLTAGE:
					case CLUSTER_1_BATTERY_183_VOLTAGE:
					case CLUSTER_1_BATTERY_184_VOLTAGE:
					case CLUSTER_1_BATTERY_185_VOLTAGE:
					case CLUSTER_1_BATTERY_186_VOLTAGE:
					case CLUSTER_1_BATTERY_187_VOLTAGE:
					case CLUSTER_1_BATTERY_188_VOLTAGE:
					case CLUSTER_1_BATTERY_189_VOLTAGE:
					case CLUSTER_1_BATTERY_190_VOLTAGE:
					case CLUSTER_1_BATTERY_191_VOLTAGE:
					case CLUSTER_1_BATTERY_192_VOLTAGE:
					case CLUSTER_1_BATTERY_193_VOLTAGE:
					case CLUSTER_1_BATTERY_194_VOLTAGE:
					case CLUSTER_1_BATTERY_195_VOLTAGE:
					case CLUSTER_1_BATTERY_196_VOLTAGE:
					case CLUSTER_1_BATTERY_197_VOLTAGE:
					case CLUSTER_1_BATTERY_198_VOLTAGE:
					case CLUSTER_1_BATTERY_199_VOLTAGE:
					case CLUSTER_1_BATTERY_200_VOLTAGE:
					case CLUSTER_1_BATTERY_201_VOLTAGE:
					case CLUSTER_1_BATTERY_202_VOLTAGE:
					case CLUSTER_1_BATTERY_203_VOLTAGE:
					case CLUSTER_1_BATTERY_204_VOLTAGE:
					case CLUSTER_1_BATTERY_205_VOLTAGE:
					case CLUSTER_1_BATTERY_206_VOLTAGE:
					case CLUSTER_1_BATTERY_207_VOLTAGE:
					case CLUSTER_1_BATTERY_208_VOLTAGE:
					case CLUSTER_1_BATTERY_209_VOLTAGE:
					case CLUSTER_1_BATTERY_210_VOLTAGE:
					case CLUSTER_1_BATTERY_211_VOLTAGE:
					case CLUSTER_1_BATTERY_212_VOLTAGE:
					case CLUSTER_1_BATTERY_213_VOLTAGE:
					case CLUSTER_1_BATTERY_214_VOLTAGE:
					case CLUSTER_1_BATTERY_215_VOLTAGE:
					case CLUSTER_1_BATTERY_216_VOLTAGE:
					case CLUSTER_1_BATTERY_217_VOLTAGE:
					case CLUSTER_1_BATTERY_218_VOLTAGE:
					case CLUSTER_1_BATTERY_219_VOLTAGE:
					case CLUSTER_1_BATTERY_220_VOLTAGE:
					case CLUSTER_1_BATTERY_221_VOLTAGE:
					case CLUSTER_1_BATTERY_222_VOLTAGE:
					case CLUSTER_1_BATTERY_223_VOLTAGE:
					case CLUSTER_1_BATTERY_224_VOLTAGE:
					case CLUSTER_1_BATTERY_225_VOLTAGE:
					case CLUSTER_1_BATTERY_226_VOLTAGE:
					case CLUSTER_1_BATTERY_227_VOLTAGE:
					case CLUSTER_1_BATTERY_228_VOLTAGE:
					case CLUSTER_1_BATTERY_229_VOLTAGE:
					case CLUSTER_1_BATTERY_230_VOLTAGE:
					case CLUSTER_1_BATTERY_231_VOLTAGE:
					case CLUSTER_1_BATTERY_232_VOLTAGE:
					case CLUSTER_1_BATTERY_233_VOLTAGE:
					case CLUSTER_1_BATTERY_234_VOLTAGE:
					case CLUSTER_1_BATTERY_235_VOLTAGE:
					case CLUSTER_1_BATTERY_236_VOLTAGE:
					case CLUSTER_1_BATTERY_237_VOLTAGE:
					case CLUSTER_1_BATTERY_238_VOLTAGE:
					case CLUSTER_1_BATTERY_239_VOLTAGE:

					case CLUSTER_1_BATTERY_00_TEMPERATURE:
					case CLUSTER_1_BATTERY_01_TEMPERATURE:
					case CLUSTER_1_BATTERY_02_TEMPERATURE:
					case CLUSTER_1_BATTERY_03_TEMPERATURE:
					case CLUSTER_1_BATTERY_04_TEMPERATURE:
					case CLUSTER_1_BATTERY_05_TEMPERATURE:
					case CLUSTER_1_BATTERY_06_TEMPERATURE:
					case CLUSTER_1_BATTERY_07_TEMPERATURE:
					case CLUSTER_1_BATTERY_08_TEMPERATURE:
					case CLUSTER_1_BATTERY_09_TEMPERATURE:
					case CLUSTER_1_BATTERY_10_TEMPERATURE:
					case CLUSTER_1_BATTERY_11_TEMPERATURE:
					case CLUSTER_1_BATTERY_12_TEMPERATURE:
					case CLUSTER_1_BATTERY_13_TEMPERATURE:
					case CLUSTER_1_BATTERY_14_TEMPERATURE:
					case CLUSTER_1_BATTERY_15_TEMPERATURE:
					case CLUSTER_1_BATTERY_16_TEMPERATURE:
					case CLUSTER_1_BATTERY_17_TEMPERATURE:
					case CLUSTER_1_BATTERY_18_TEMPERATURE:
					case CLUSTER_1_BATTERY_19_TEMPERATURE:
					case CLUSTER_1_BATTERY_20_TEMPERATURE:
					case CLUSTER_1_BATTERY_21_TEMPERATURE:
					case CLUSTER_1_BATTERY_22_TEMPERATURE:
					case CLUSTER_1_BATTERY_23_TEMPERATURE:
					case CLUSTER_1_BATTERY_24_TEMPERATURE:
					case CLUSTER_1_BATTERY_25_TEMPERATURE:
					case CLUSTER_1_BATTERY_26_TEMPERATURE:
					case CLUSTER_1_BATTERY_27_TEMPERATURE:
					case CLUSTER_1_BATTERY_28_TEMPERATURE:
					case CLUSTER_1_BATTERY_29_TEMPERATURE:
					case CLUSTER_1_BATTERY_30_TEMPERATURE:
					case CLUSTER_1_BATTERY_31_TEMPERATURE:
					case CLUSTER_1_BATTERY_32_TEMPERATURE:
					case CLUSTER_1_BATTERY_33_TEMPERATURE:
					case CLUSTER_1_BATTERY_34_TEMPERATURE:
					case CLUSTER_1_BATTERY_35_TEMPERATURE:
					case CLUSTER_1_BATTERY_36_TEMPERATURE:
					case CLUSTER_1_BATTERY_37_TEMPERATURE:
					case CLUSTER_1_BATTERY_38_TEMPERATURE:
					case CLUSTER_1_BATTERY_39_TEMPERATURE:
					case CLUSTER_1_BATTERY_40_TEMPERATURE:
					case CLUSTER_1_BATTERY_41_TEMPERATURE:
					case CLUSTER_1_BATTERY_42_TEMPERATURE:
					case CLUSTER_1_BATTERY_43_TEMPERATURE:
					case CLUSTER_1_BATTERY_44_TEMPERATURE:
					case CLUSTER_1_BATTERY_45_TEMPERATURE:
					case CLUSTER_1_BATTERY_46_TEMPERATURE:
					case CLUSTER_1_BATTERY_47_TEMPERATURE:

					case CLUSTER_1_CHARGE_INDICATION:
					case CLUSTER_RUN_STATE:
					case SYSTEM_INSULATION:

					case SYSTEM_ACCEPT_MAX_CHARGE_CURRENT:
					case SYSTEM_ACCEPT_MAX_DISCHARGE_CURRENT:
					case SYSTEM_OVER_VOLTAGE_PROTECTION:
					case SYSTEM_UNDER_VOLTAGE_PROTECTION:

					case CLUSTER_1_MAX_CELL_TEMPERATURE_ID:
					case CLUSTER_1_MAX_CELL_VOLTAGE_ID:
					case CLUSTER_1_MIN_CELL_TEMPERATURE_ID:
					case CLUSTER_1_MIN_CELL_VOLTAGE_ID:
						return new IntegerReadChannel(s, channelId);
					}
					return null;
				}) //
		).flatMap(channel -> channel);
	}
}
