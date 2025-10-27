package com.example.ohtani_project.entity;

//大谷選手の情報を扱う Playerモデル（Entityクラス） の作成
//DBテーブルと1対1の対応(python:models.py)
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity // このクラスがDBテーブルと対応することを指定
@Data // Lombok。getter/setter/toStringを自動生成
@Table(name = "players") // ← 実際のテーブル名を指定
public class Player {

	@Id // このフィールドがデータベーステーブルの主キー(Primary Key)を指定
	@GeneratedValue(strategy = GenerationType.IDENTITY) // データベース側のAUTO_INCREMENT(MySQL)やSERIAL(PostgreSQL)機能を使用し
	//レコード挿入時に、データベースが自動的にidを割り当てます
	private Long id;

	//カラム(列)に対する詳細設定を行う
	@Column(nullable = false, length = 30) //このカラムにNULL値を許可しない。文字列を30文字に制限
	private String playerName;//選手名

	@Column(nullable = false, length = 30)
	private String teamName;//所属チーム名

	@Column(nullable = false, length = 20)
	private String position;//ポジション（例：投手、内野手など）

	private Integer jerseyNumber;// 背番号（null可）

	@Column(length = 30)
	private String birthplace;//出身地

	private LocalDate birthday;//生年月日

	private Integer height;//身長

	private Integer weight;//体重
}