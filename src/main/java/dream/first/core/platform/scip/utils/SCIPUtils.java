/**
 * 
 */
package dream.first.core.platform.scip.utils;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.yelong.tools.net.ipv4.Ipv4;
import org.yelong.tools.net.ipv4.Ipv4Utils;

import dream.first.core.platform.scip.model.SCIP;

/**
 * SCIP工具类
 */
public final class SCIPUtils {

	private SCIPUtils() {
	}

	/**
	 * 判断指定的 ipv4 是否在 SCIP范围内
	 * 
	 * @param scips 范围
	 * @param ip    需要判断的ip
	 * @return <code>true</code> 判断的ip在指定的ip范围内
	 */
	public static boolean contains(List<SCIP> scips, String ip) {
		Ipv4 ipv4 = new Ipv4(ip);
		for (SCIP scip : scips) {
			String startIp = scip.getStartIp();
			String endIp = scip.getEndIp();
			Ipv4 startIpv4 = new Ipv4(startIp);
			if (!Ipv4Utils.validateFirstThreeSection(ip, startIp)) {
				continue;
			}
			String fourSectionStr = startIpv4.getFourSectionStr();// 第四段
			if ("*".equals(fourSectionStr)) {
				return true;
			}
			Integer userFourSection = ipv4.getFourSection();
			Ipv4 endIpv4 = StringUtils.isBlank(endIp) ? null : new Ipv4(endIp);
			if (null != endIpv4) {
				// 用户id第四段在起始ip和结束ip之间
				if (userFourSection >= startIpv4.getFourSection() && userFourSection <= endIpv4.getFourSection()) {
					return true;
				}
			} else {
				// 不存在结束ip且ip第四段相等
				if (userFourSection == startIpv4.getFourSection()) {
					return true;
				}
			}

		}
		return false;
	}

}
