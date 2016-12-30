package com.zyf.dao.api;

import java.util.List;

import com.zyf.dao.Seckill;

/**
 * @author yunfeng.zang
 * @createTime 2016年12月29日下午7:35:56
 */
public interface SeckillMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table seckill
	 *
	 * @mbggenerated Thu Dec 29 18:43:52 CST 2016
	 */
	int deleteByPrimaryKey(Long seckillId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table seckill
	 *
	 * @mbggenerated Thu Dec 29 18:43:52 CST 2016
	 */
	int insert(Seckill record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table seckill
	 *
	 * @mbggenerated Thu Dec 29 18:43:52 CST 2016
	 */
	int insertSelective(Seckill record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table seckill
	 *
	 * @mbggenerated Thu Dec 29 18:43:52 CST 2016
	 */
	Seckill selectByPrimaryKey(Long seckillId);

	List<Seckill> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table seckill
	 *
	 * @mbggenerated Thu Dec 29 18:43:52 CST 2016
	 */
	int updateByPrimaryKeySelective(Seckill record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table seckill
	 *
	 * @mbggenerated Thu Dec 29 18:43:52 CST 2016
	 */
	int updateByPrimaryKey(Seckill record);
}